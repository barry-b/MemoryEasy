package com.example.memoryeasy.model.domain;

public class RegisterResponse {


    /**
     * code : 0
     * data : {}
     * message : string
     * success : false
     */

    private Integer code;
    private DataBean data;
    private String message;
    private Boolean success;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public static class DataBean {
    }
}
