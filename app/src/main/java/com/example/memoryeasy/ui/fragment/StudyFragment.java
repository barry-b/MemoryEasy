package com.example.memoryeasy.ui.fragment;

import androidx.viewpager.widget.ViewPager;

import com.example.memoryeasy.R;
import com.example.memoryeasy.adapter.StudyCardsPagerAdapter;
import com.example.memoryeasy.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class StudyFragment extends BaseFragment {

    private ViewPager mVpStudy;

    private StudyCardsPagerAdapter mAdapter;

    private List<String> mTitleList = new ArrayList<>();

    @Override
    protected int onLoadView() {
        return R.layout.fragment_study;
    }

    @Override
    protected void initView() {
        mVpStudy = mView.findViewById(R.id.vp_study);

        mAdapter = new StudyCardsPagerAdapter();
        mVpStudy.setOffscreenPageLimit(mTitleList.size());
        mVpStudy.setPageMargin(80);

        int i1 = (Integer.MAX_VALUE / 2) % mTitleList.size();
        int targetPoint = (Integer.MAX_VALUE / 2) - i1;

        mAdapter.setData(mTitleList);
        mVpStudy.setAdapter(mAdapter);
        mVpStudy.setCurrentItem(targetPoint);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {
        mTitleList.add("Java");
        mTitleList.add("C++");
        mTitleList.add("Android");
        mTitleList.add("Python");
        mTitleList.add("Go");
    }
}
