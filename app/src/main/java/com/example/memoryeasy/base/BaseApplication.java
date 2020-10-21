package com.example.memoryeasy.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.example.memoryeasy.utils.LogUtil;


public class BaseApplication extends Application {

    private static Handler mHandler = null;

    private static Context sContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.init(this.getPackageName(),false);

        mHandler = new Handler();

        sContext = getBaseContext();
    }

    public static Handler getmHandler() {
        return mHandler;
    }

    public static Context getContext() {
        return sContext;
    }
}
