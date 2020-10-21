package com.example.memoryeasy.base;

public interface IBaseCallback {

    /**
     * 加载中
     */
    void onLoading();

    /**
     * 网络错误
     */
    void onNetworkError();

    /**
     * 数据为空
     */
    void onEmpty();
}
