package com.example.memoryeasy.model.api;

public interface ResponseCallback {

    void onSuccess(String result);

    void onFailure(Exception e);
}
