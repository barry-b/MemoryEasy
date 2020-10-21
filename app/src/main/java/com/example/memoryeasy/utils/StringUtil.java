package com.example.memoryeasy.utils;

public class StringUtil {

    public static boolean isNull(String str){
        if (str != null && str.length() > 0){
            return false;
        }
        return true;
    }
}
