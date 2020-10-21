package com.example.memoryeasy.ui.activity;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.memoryeasy.R;
import com.example.memoryeasy.base.BaseActivity;
import com.example.memoryeasy.model.api.Api;
import com.example.memoryeasy.model.api.ApiConfig;
import com.example.memoryeasy.model.api.ResponseCallback;
import com.example.memoryeasy.model.domain.LoginResponse;
import com.example.memoryeasy.utils.StringUtil;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "LoginActivity";
    private Button mButton;
    private EditText mMobileEd;
    private EditText mPwdEd;
    private LinearLayout mLl;

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        mButton = findViewById(R.id.btn_login);
        mMobileEd = findViewById(R.id.et_account);
        mPwdEd = findViewById(R.id.et_pwd);
        mLl = findViewById(R.id.login_load);

    }

    @Override
    protected void initEvent() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String mobile = mMobileEd.getText().toString().trim();
        String pwd = mPwdEd.getText().toString().trim();
        if (StringUtil.isNull(mobile)) {
            showToast("手机号不能为空");
        } else if (StringUtil.isNull(pwd)) {
            showToast("密码不能为空");
        } else {
            mLl.setVisibility(View.VISIBLE);
            Map<String, Object> map = new HashMap<>();
            map.put("mobile", mobile);
            map.put("password", pwd);

            Api.Config(ApiConfig.USER_LOGIN, map).postRequest(this, true, new ResponseCallback() {
                @Override
                public void onSuccess(String result) {
                    Log.d(TAG, "onSuccess: ---->" + result);
                    LoginResponse loginResponse = new Gson().fromJson(result, LoginResponse.class);
                    setStringToSp("token", loginResponse.getData().getItem());
                    Looper.prepare();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void  run() {
                            if (loginResponse.getCode() == 20000) {
                                navigateTo(MainActivity.class);
                                showToast("登陆成功");
                            } else {
                                showToast("登陆失败");
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        mLl.setVisibility(View.GONE);
                                    }
                                });
                            }
                        }
                    }, 3000);
                    Looper.loop();
                }

                @Override
                public void onFailure(Exception e) {
                    Log.d(TAG, "onFailure: ---->" + e.toString());
                }
            });

        }


    }

    @Override
    protected void onStop() {
        super.onStop();
        mLl.setVisibility(View.GONE);
    }
}
