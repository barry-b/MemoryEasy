package com.example.memoryeasy.ui.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.memoryeasy.R;
import com.example.memoryeasy.adapter.AddContentAdapter;
import com.example.memoryeasy.base.BaseApplication;
import com.example.memoryeasy.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AddContentFragment extends BaseFragment {

    private static int sCurPos;
    private AddContentAdapter mAdapter;

    private RecyclerView rvAddContent;

    List<String> cardTitleList = new ArrayList<>();
    List<String> directoryTitleList = new ArrayList<>();

    @Override
    protected int onLoadView() {
        return R.layout.fragment_add_content;
    }

    public static AddContentFragment getInstance(int pos){
        AddContentFragment fragment = new AddContentFragment();
        sCurPos = pos;
        return fragment;
    }

    @Override
    protected void initData() {
        cardTitleList.add(0,"java");
        cardTitleList.add(1,"c++");
        cardTitleList.add(2,"python");
        cardTitleList.add(3,"go");
        cardTitleList.add(4,"kotlin");

        directoryTitleList.add(0,"编程学习");
        directoryTitleList.add(1,"语言学习");
        directoryTitleList.add(2,"考研");
        directoryTitleList.add(3,"理财");
    }

    @Override
    protected void initView() {
        rvAddContent = mView.findViewById(R.id.rv_add_content);

        rvAddContent.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new AddContentAdapter();
        if (sCurPos == 0) {
            mAdapter.setData(directoryTitleList);
        }else{
            mAdapter.setData(cardTitleList);
        }
        rvAddContent.setAdapter(mAdapter);
    }
}
