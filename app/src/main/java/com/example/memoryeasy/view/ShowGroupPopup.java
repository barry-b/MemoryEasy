package com.example.memoryeasy.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.example.memoryeasy.R;

public class ShowGroupPopup extends PopupWindow {

    private final View mPopupView;
    private int mWidth;

    public ShowGroupPopup(Context context) {

        super(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setOutsideTouchable(true);
        setFocusable(true);
        mPopupView = LayoutInflater.from(context).inflate(R.layout.layout_show_group, null);
        setContentView(mPopupView);
       // setWidth(300);
    }


    @Override
    public int getWidth() {
        return mWidth;
    }

    @Override
    public void setWidth(int width) {
        mWidth = width;
    }
}
