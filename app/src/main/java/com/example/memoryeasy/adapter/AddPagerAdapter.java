package com.example.memoryeasy.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.memoryeasy.ui.fragment.AddContentFragment;
import com.example.memoryeasy.utils.LogUtil;

import java.util.HashMap;
import java.util.Map;

public class AddPagerAdapter extends FragmentPagerAdapter {

    private static final String TAG = "AddPagerAdapter";
    Map<Integer,String> mData = new HashMap<>();

    public AddPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        AddContentFragment fragment = AddContentFragment.getInstance(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mData.get(position);
    }


    public void setData(Map<Integer, String> data) {
        mData.clear();
        mData.putAll(data);
        notifyDataSetChanged();
    }
}
