package com.example.memoryeasy.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import com.example.memoryeasy.R;
import com.example.memoryeasy.adapter.CreateCardAdapter;
import com.example.memoryeasy.base.BaseActivity;
import com.example.memoryeasy.base.BaseApplication;
import com.example.memoryeasy.view.ShowGroupPopup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@SuppressLint("NonConstantResourceId")
public class AddCardActivity extends BaseActivity {

    private static final String TAG = "AddCardActivity";
    public CardView mCardView;
    public ImageView mBtnBack;
    public ViewPager mPager;

    private Unbinder mBind;
    private ShowGroupPopup mGroupPopup;
    private Button mNext;
    private CreateCardAdapter mAdapter;
    private int mCurPosition ;


    @Override
    protected int initLayout() {
        return R.layout.activity_add_card;
    }

    @Override
    protected void initView() {
        mCardView = findViewById(R.id.choose_group);
        mBtnBack = findViewById(R.id.img_back);
        mPager = findViewById(R.id.vp_add);
        mNext = findViewById(R.id.btn_next);

        mAdapter = new CreateCardAdapter();
        mCurPosition = mAdapter.getCurPosition();
        mPager.setAdapter(mAdapter);

        mGroupPopup = new ShowGroupPopup(this);
        mGroupPopup.setWidth(mGroupPopup.getWidth());
    }

    @Override
    protected void initEvent() {
        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGroupPopup.showAsDropDown(v);
            }
        });
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddCardActivity.this.finish();
            }
        });
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPager.setCurrentItem(++mCurPosition);
            }
        });

    }
}
