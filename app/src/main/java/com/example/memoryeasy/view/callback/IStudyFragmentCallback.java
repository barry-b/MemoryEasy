package com.example.memoryeasy.view.callback;

import com.example.memoryeasy.base.IBaseCallback;
import com.example.memoryeasy.model.domain.ShowCardMsg;
import com.example.memoryeasy.model.domain.User;

import java.util.List;

public interface IStudyFragmentCallback extends IBaseCallback {

    /**
     * 学习数据加载
     */
    void onStudyContentLoad(List<ShowCardMsg.DataBean> cardContents);

    /**
     * 用户个人数据加载
     */
    void onUserMsgLoad(List<User.DataBean> userMsg);

    /**
     * 同步数据
     */
    void onRefresh(List<ShowCardMsg.DataBean> contents);

}
