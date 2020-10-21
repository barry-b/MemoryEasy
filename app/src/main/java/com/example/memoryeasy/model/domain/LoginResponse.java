package com.example.memoryeasy.model.domain;

public class LoginResponse {


    /**
     * success : true
     * code : 20000
     * message : 登录成功
     * data : {"item":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ5aXlpLXVzZXIiLCJpYXQiOjE2MDMwMDczOTYsImV4cCI6MTYwMzAyODk5NiwiaWQiOiIxMzA4MjE0NzIxMTAyNTI0NDE4Iiwibmlja25hbWUiOiJ0ZXN0IiwiYXZhdGFyIjoiaHR0cHM6Ly95aXlpLWZpbGUub3NzLWNuLXNoZW56aGVuLmFsaXl1bmNzLmNvbS8yMDIwLzEwLzE3LzgzNWYxNzdhYmZjNzQwNTA5ZjdmMjIwZWExZDI3N2EwLmpwZyIsIm1vYmlsZSI6IjEzMDMwMjM3ODEwIiwic2lnbiI6IuWTiOWTiCJ9._bllZZAjqoeZViFTWFbh7C7r62ksoiANlh0qzkIbD-4"}
     */

    private Boolean success;
    private Integer code;
    private String message;
    private DataBean data;

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * item : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ5aXlpLXVzZXIiLCJpYXQiOjE2MDMwMDczOTYsImV4cCI6MTYwMzAyODk5NiwiaWQiOiIxMzA4MjE0NzIxMTAyNTI0NDE4Iiwibmlja25hbWUiOiJ0ZXN0IiwiYXZhdGFyIjoiaHR0cHM6Ly95aXlpLWZpbGUub3NzLWNuLXNoZW56aGVuLmFsaXl1bmNzLmNvbS8yMDIwLzEwLzE3LzgzNWYxNzdhYmZjNzQwNTA5ZjdmMjIwZWExZDI3N2EwLmpwZyIsIm1vYmlsZSI6IjEzMDMwMjM3ODEwIiwic2lnbiI6IuWTiOWTiCJ9._bllZZAjqoeZViFTWFbh7C7r62ksoiANlh0qzkIbD-4
         */

        private String item;

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }
    }
}
