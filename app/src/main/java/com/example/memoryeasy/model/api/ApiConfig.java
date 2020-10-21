package com.example.memoryeasy.model.api;

public class ApiConfig {

    public static final String BASE_URL = "http://172.16.15.141:10086/global";
    //用户登录 post请求
    public static final String USER_LOGIN = "/user/login";
    //用户注册 post请求
    public static final String USER_REGISTER = "/user/register";
    //获取验证码 get请求
    public static final String GET_SMS_CODE = "/user/getSmsCode/";

    //点击首页学习时要展示的内容
    // 包括要学习的卡片集和要学习的卡片和卡片集数量 get请求
    public static final String SHOW_STUDY = "/card/study/showStudy";


}
