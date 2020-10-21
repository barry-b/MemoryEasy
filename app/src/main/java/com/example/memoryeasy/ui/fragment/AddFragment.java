package com.example.memoryeasy.ui.fragment;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.memoryeasy.R;
import com.example.memoryeasy.adapter.AddPagerAdapter;
import com.example.memoryeasy.base.BaseFragment;
import com.example.memoryeasy.view.AddContainer;
import com.google.android.material.tabs.TabLayout;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

public class AddFragment extends BaseFragment {

    private Map<Integer,String> data = new HashMap<>();

    public TabLayout mTabTitle;
    public ViewPager mVpContent;


    @Override
    protected int onLoadView() {
        return R.layout.fragment_add;
    }



    @Override
    protected void initData() {
        data.put(0,"文件夹");
        data.put(1,"卡片库");
    }

    @Override
    protected void initView() {
        mTabTitle = mView.findViewById(R.id.tab_add_title);
        mVpContent = mView.findViewById(R.id.vp_add);

        mTabTitle.setupWithViewPager(mVpContent);
        AddPagerAdapter adapter = new AddPagerAdapter(getChildFragmentManager());

        adapter.setData(data);
        mVpContent.setAdapter(adapter);


    }

    @Override
    protected void initEvent() {

    }




}
