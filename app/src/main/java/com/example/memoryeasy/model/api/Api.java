package com.example.memoryeasy.model.api;

import android.content.Context;
import android.util.Log;

import com.example.memoryeasy.utils.LogUtil;
import com.example.memoryeasy.utils.StringUtil;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Api {


    private static final String TAG = "Api";
    private static Api sApi;
    private static OkHttpClient sClient;
    private static String sTargetUrl;
    private static Map<String, Object> sParams;

    private Api() {
    }

    /**
     * 配置接口
     *
     * @param url    接着baseUrl
     * @param params 封装好的属性带去请求
     * @return
     */
    public static Api Config(String url, Map<String, Object> params) {
        if (sApi == null) {
            sApi = new Api();
        }
        sClient = new OkHttpClient.Builder().build();
        sTargetUrl = ApiConfig.BASE_URL + url;
        sParams = params;
        return sApi;
    }

    public void postRequest(Context context,boolean needAppend, ResponseCallback callback) {

        if(needAppend){
            sTargetUrl = appendUrl(sTargetUrl);
        }
        JSONObject jsonObject = new JSONObject(sParams);
        Log.d(TAG, "postRequest: url----->" + sTargetUrl);
        Log.d(TAG, "postRequest: params----> " + jsonObject.toString());
        RequestBody requestBody = RequestBody.
                create(MediaType.parse("application/json"), jsonObject.toString());

        Request request = new Request.Builder()
                .addHeader("Content-Type", "application/json")
                .url(sTargetUrl)
                .post(requestBody)
                .build();

        Call call = sClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.onSuccess(response.body().string());
            }
        });
    }

    public void getRequest(Context context,boolean isGetSmsReq, ResponseCallback callback) {

        if (isGetSmsReq) {
            sTargetUrl += sParams.get("mobile");
        }
        LogUtil.d(TAG,sTargetUrl);

        Request request = new Request.Builder()
                .url(sTargetUrl)
                .build();

        Call call = sClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.onSuccess(response.body().string());
            }
        });
    }


    public String appendUrl(String url) {
        StringBuffer appendUrl = new StringBuffer();

        Iterator<Map.Entry<String, Object>> iterator = sParams.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            if (StringUtil.isNull(appendUrl.toString())) {
                appendUrl.append("?");
            } else {
                appendUrl.append("&");
            }
            appendUrl.append(next.getKey()).append("=").append(next.getValue());
        }
        url += appendUrl.toString();
        return url;
    }


}
