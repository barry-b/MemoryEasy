package com.example.memoryeasy.ui.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

import com.example.memoryeasy.R;
import com.example.memoryeasy.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends BaseActivity {

    @Override
    protected int initLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sp = this.getSharedPreferences("sp", MODE_PRIVATE);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (sp.contains("token")) {
                    navigateTo(MainActivity.class);
                }else{
                    navigateTo(HomeActivity.class);
                }
                finish();
            }
        },2000);
    }
}
