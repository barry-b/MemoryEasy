package com.example.memoryeasy.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.example.memoryeasy.R;
import com.example.memoryeasy.base.BaseFragment;
import com.example.memoryeasy.ui.fragment.AddFragment;
import com.example.memoryeasy.ui.fragment.MoreFragment;
import com.example.memoryeasy.ui.fragment.StudyFragment;
import com.example.memoryeasy.view.AddContainer;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public BottomNavigationView mBottomNavigationView;

    private StudyFragment mStudyFragment;
    private AddFragment mAddFragment;
    private MoreFragment mMoreFragment;
    private FragmentManager mManager;
    private AddContainer mAddContainer;
    private ValueAnimator mEnterAnimator,mExitAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initEvent();
        initFragment();
        initAlphaAnimation();
        switchFragment(mStudyFragment);
    }

    private void initView() {
        mBottomNavigationView = findViewById(R.id.bottom_nav_view);

        mAddContainer = new AddContainer(getApplicationContext());
    }


    private void initFragment() {
        mStudyFragment = new StudyFragment();
        mAddFragment = new AddFragment();
        mMoreFragment = new MoreFragment();

        mManager = getSupportFragmentManager();
    }

    private void initEvent() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.item_study:
                        switchFragment(mStudyFragment);
                        break;
                    case R.id.item_add:
                        mAddContainer.showAtLocation(mBottomNavigationView,Gravity.BOTTOM,0,500);
                        mEnterAnimator.start();
                        switchFragment(mAddFragment);
                        break;
                    case R.id.item_more:
                        switchFragment(mMoreFragment);
                        break;
                }
                return true;
            }
        });

        //取消弹窗点击事件
        mAddContainer.setOnCancelClickListener(new AddContainer.OnCancelClickListener() {
            @Override
            public void onCancelClick() {
                mAddContainer.dismiss();
            }
        });

        mAddContainer.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                mExitAnimator.start();
            }
        });

        //添加按钮点击事件
        mAddContainer.setOnAddItemClickListener(new AddContainer.OnAddItemClickListener() {
            @Override
            public void onAddCardClick() {
                startActivity(new Intent(MainActivity.this,AddCardActivity.class));
            }

            @Override
            public void onAddCardLibClick() {

            }

            @Override
            public void onAddDirClick() {

            }
        });
    }

    /**
     * 切换fragment
     * @param fragment
     */
    private void switchFragment(BaseFragment fragment) {
        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.replace(R.id.fragment_contain,fragment);
        transaction.commit();
    }

    /**
     * 设置背景透明度
     *
     * @param alpha
     */
    private void setBackGroundAlpha(float alpha){
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = alpha;
        window.setAttributes(attributes);
    }


    /**
     * 透明度变化动画
     */
    private void initAlphaAnimation() {
        mEnterAnimator = ValueAnimator.ofFloat(1.0f,0.6f);
        mEnterAnimator.setDuration(1000);
        mEnterAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                setBackGroundAlpha((Float) animation.getAnimatedValue());
            }
        });
        mExitAnimator = ValueAnimator.ofFloat(0.6f,1.0f);
        mExitAnimator.setDuration(1000);
        mExitAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                setBackGroundAlpha((Float) animation.getAnimatedValue());
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mAddContainer.dismiss();
    }
}
