package com.example.memoryeasy.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.memoryeasy.R;

public class AddContainer extends PopupWindow {


    private RelativeLayout popupCancel;

    private final View mPopView;
    private OnCancelClickListener mListener;
    private LinearLayout mLl;
    private OnAddItemClickListener addListener;
    private LinearLayout mAddCards;

    public AddContainer(Context context) {
        super(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        //不设置这个点击外部是无法关闭的
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setOutsideTouchable(true);
        setFocusable(true);
        mPopView = LayoutInflater.from(context).inflate(R.layout.popup_add_index, null);
        setContentView(mPopView);
        setAnimationStyle(R.style.PopupWindowAnim);
        initView();
        initListener();
    }

    private void initListener() {
        popupCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onCancelClick();
            }
        });
        mLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onCancelClick();
            }
        });
        mAddCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addListener.onAddCardClick();
            }
        });
    }

    private void initView() {
        popupCancel = mPopView.findViewById(R.id.popup_cancel);
        mLl = mPopView.findViewById(R.id.cancel_out);
        mAddCards = mPopView.findViewById(R.id.add_card);
    }

    public void setOnCancelClickListener(OnCancelClickListener listener){
        mListener = listener;
    }

    public void setOnAddItemClickListener(OnAddItemClickListener listener){
        addListener = listener;
    }

    public interface OnCancelClickListener {
        void onCancelClick();
    }

    public interface OnAddItemClickListener{
        void onAddCardClick();
        void onAddCardLibClick();
        void onAddDirClick();
    }
}
