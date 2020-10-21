package com.example.memoryeasy.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.memoryeasy.R;
import com.example.memoryeasy.base.BaseActivity;
import com.example.memoryeasy.utils.TextOneByOneUtil;

public class HomeActivity extends BaseActivity {

    private Button mToLogin;
    private Button mToRegister;
    private String str = "面向大海，春暖花开";
    private TextView mTv;

    @Override
    protected int initLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        mToLogin = findViewById(R.id.btn_to_login);
        mToRegister = findViewById(R.id.btn_to_register);
        mTv = findViewById(R.id.tv_home);

    }

    @Override
    protected void onResume() {
        super.onResume();
        new TextOneByOneUtil(mTv,str,400);
    }

    @Override
    protected void initEvent() {
        mToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateTo(LoginActivity.class);
            }
        });

        mToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateTo(RegisterActivity.class);
            }
        });
    }
}
