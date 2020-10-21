package com.example.memoryeasy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;


import com.example.memoryeasy.R;

import java.util.ArrayList;
import java.util.List;

public class StudyCardsPagerAdapter extends PagerAdapter {
    private List<String> mData = new ArrayList<>();
    private int mRealPos;

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        mRealPos = position % mData.size();
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.list_study_card, container, false);
        TextView tv = view.findViewById(R.id.tv_test);
        String text = mData.get(mRealPos);
        tv.setText(text);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    public void setData(List<String> textList) {
        mData.clear();
        mData.addAll(textList);
        notifyDataSetChanged();
    }
}
