package com.example.memoryeasy.presenter.imp;

import com.example.memoryeasy.base.IBasePresenter;
import com.example.memoryeasy.view.callback.IStudyFragmentCallback;

public interface IStudyFragmentPresenter extends IBasePresenter<IStudyFragmentCallback> {

    /**
     * 根据用户token去拿对应用户数据
     * @param token
     */
    void getStudyContentByToken(String token);

    /**
     * 带着用户token去拿对应用户个人信息数据
     * @param token
     */
    void getUserMsg(String token);
}
