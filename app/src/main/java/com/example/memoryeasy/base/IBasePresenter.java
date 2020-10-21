package com.example.memoryeasy.base;

public interface IBasePresenter<T> {

    /**
     * 注册回调
     *
     */
    void registerCallback(T t);

    /**
     * 取消注册
     *
     */
    void unRegisterCallback(T t);
}
