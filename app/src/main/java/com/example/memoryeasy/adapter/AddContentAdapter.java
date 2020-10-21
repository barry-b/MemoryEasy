package com.example.memoryeasy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.memoryeasy.R;

import java.util.ArrayList;
import java.util.List;

public class AddContentAdapter extends RecyclerView.Adapter<AddContentAdapter.InnerHolder> {

    List<String> mData = new ArrayList<>();

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_add_content, parent, false);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        String s = mData.get(position);
        holder.setData(s);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(List<String> titleList) {
        mData.clear();
        mData.addAll(titleList);
        notifyDataSetChanged();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        private final TextView mTextView;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.card_rep_title);
        }

        public void setData(String s) {
            mTextView.setText(s);
        }
    }
}
