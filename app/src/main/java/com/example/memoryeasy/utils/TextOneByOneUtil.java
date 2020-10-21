package com.example.memoryeasy.utils;

import android.widget.TextView;

import java.time.Duration;

public class TextOneByOneUtil {

    private final TextView mTv;
    private String mStr;
    private long mDuration;
    private int n = 0;
    private int count = 0;
    private final int mLength;

    public TextOneByOneUtil(TextView tv, String str, long duration) {
        mTv = tv;
        mStr = str;
        mDuration = duration;
        mLength = str.length();
        startTvRun(n);
    }

    private void startTvRun(int n) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String s = mStr.substring(0, n);
                    mTv.post(new Runnable() {
                        @Override
                        public void run() {
                            mTv.setText(s);
                        }
                    });
                    Thread.sleep(mDuration);
                    count = n + 1;
                    if(count <= mLength){
                        startTvRun(count);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
