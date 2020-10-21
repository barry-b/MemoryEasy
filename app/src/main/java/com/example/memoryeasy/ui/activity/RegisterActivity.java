package com.example.memoryeasy.ui.activity;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.memoryeasy.R;
import com.example.memoryeasy.base.BaseActivity;
import com.example.memoryeasy.model.api.Api;
import com.example.memoryeasy.model.api.ApiConfig;
import com.example.memoryeasy.model.api.ResponseCallback;
import com.example.memoryeasy.model.domain.RegisterResponse;
import com.example.memoryeasy.utils.LogUtil;
import com.example.memoryeasy.utils.StringUtil;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends BaseActivity {

    private static final String TAG = "RegisterActivity";
    private TextView mGetVerifyCode;
    //判断是否还在计数
    private boolean isCountDown;
    private VerifyCodeCountDownTimer mTimer;
    private EditText mEtMobile;
    private EditText mEtUsername;
    private EditText mEtPwd;
    private EditText mEtCode;
    private Button mBtnReg;

    private Map<String, Object> mGetCodeMap = new HashMap<>();
    private Map<String, Object> mRegisterMap = new HashMap<>();
    private EditText mEtSign;

    @Override
    protected int initLayout() {
        return R.layout.activity_register;
    }


    @Override
    protected void initView() {
        mEtMobile = findViewById(R.id.et_reg_mobile);
        mEtUsername = findViewById(R.id.et_reg_username);
        mEtPwd = findViewById(R.id.et_reg_pwd);
        mEtCode = findViewById(R.id.et_reg_code);
        mEtSign = findViewById(R.id.et_reg_sign);
        mBtnReg = findViewById(R.id.btn_register);

        mGetVerifyCode = findViewById(R.id.get_verify_code);

        mTimer = new VerifyCodeCountDownTimer(60000, 1000);
    }

    @Override
    protected void initEvent() {
        mBtnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });


        mGetVerifyCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile = mEtMobile.getText().toString().trim();
                if (!StringUtil.isNull(mobile)) {
                    mTimer.start();
                    getVerifyCode(mobile);
                } else {
                    showToast("手机号不能为空");
                }
            }
        });

    }

    private void getVerifyCode(String mobile) {

        mGetCodeMap.put("mobile", mobile);
        Api config = Api.Config(ApiConfig.GET_SMS_CODE, mGetCodeMap);
        config.getRequest(mContext, true, new ResponseCallback() {
            @Override
            public void onSuccess(String result) {
                LogUtil.d(TAG, "onSuccess ---->" + result);
            }

            @Override
            public void onFailure(Exception e) {
                LogUtil.d(TAG, "onFailure --->" + e.toString());
            }
        });
    }

    private void register() {
        String mobile = mEtMobile.getText().toString().trim();
        String pwd = mEtPwd.getText().toString().trim();
        String nickname = mEtUsername.getText().toString().trim();
        String verifyCode = mEtCode.getText().toString().trim();
        String sign = mEtSign.getText().toString().trim();
        if (StringUtil.isNull(mobile)) {
            showToast("手机号不能为空");
        } else if (StringUtil.isNull(pwd)) {
            showToast("密码不能为空");
        } else if (StringUtil.isNull(nickname)) {
            showToast("用户名不能为空");
        } else if (StringUtil.isNull(verifyCode)) {
            showToast("验证码不能为空");
        } else if(StringUtil.isNull(sign)){
            showToast("请输入个性签名");
        } else{
            mRegisterMap.put("mobile", mobile);
            mRegisterMap.put("password", pwd);
            mRegisterMap.put("sign",sign);
            mRegisterMap.put("nickname", nickname);
            mRegisterMap.put("code", verifyCode);
            Api config = Api.Config(ApiConfig.USER_REGISTER, mRegisterMap);
            config.postRequest(mContext,false, new ResponseCallback() {
                @Override
                public void onSuccess(String result) {
                    LogUtil.d(TAG, result);
                    RegisterResponse registerResponse = new Gson().fromJson(result, RegisterResponse.class);
                    if (registerResponse.getCode() == 20000) {
                        showToastSync("注册成功");
                        navigateTo(LoginActivity.class);
                    }else{
                        showToastSync("注册失败");
                    }
                }

                @Override
                public void onFailure(Exception e) {
                    LogUtil.d(TAG, e.toString());
                }
            });
        }
    }


    private class VerifyCodeCountDownTimer extends CountDownTimer {

        public VerifyCodeCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        //计时过程
        @Override
        public void onTick(long millisUntilFinished) {
            mGetVerifyCode.setClickable(false);
            mGetVerifyCode.setEnabled(false);
            mGetVerifyCode.setText(millisUntilFinished / 1000 + "秒");
        }

        //计时完毕过程
        @Override
        public void onFinish() {
            mGetVerifyCode.setText("重新获取");
            mGetVerifyCode.setEnabled(true);
            mGetVerifyCode.setClickable(true);
        }
    }
}
