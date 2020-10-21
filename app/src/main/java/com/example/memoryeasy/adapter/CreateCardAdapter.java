package com.example.memoryeasy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.memoryeasy.R;

public class CreateCardAdapter extends PagerAdapter {

    private int mCurPosition;

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        mCurPosition = position;
        View view = LayoutInflater.from(container.getContext()).
                inflate(R.layout.layout_create_card, container, false);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    public int getCurPosition() {
        return mCurPosition;
    }
}
