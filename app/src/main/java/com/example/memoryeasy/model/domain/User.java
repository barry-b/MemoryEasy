package com.example.memoryeasy.model.domain;

/**
 *  点击首页学习时要展示的内容
 *  包括要学习的卡片集和要学习的卡片和卡片集数量 get请求
 */
public class User {


    /**
     * success : true
     * code : 20000
     * message : 成功
     * data : {"user":{"id":"1318525725518598145","nickname":"hhh","mobile":"13189247675","avatar":"https://yiyi-file.oss-cn-shenzhen.aliyuncs.com/user_avatar/%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F.jpg","sign":"hhh"}}
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
         * user : {"id":"1318525725518598145","nickname":"hhh","mobile":"13189247675","avatar":"https://yiyi-file.oss-cn-shenzhen.aliyuncs.com/user_avatar/%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F.jpg","sign":"hhh"}
         */

        private UserBean user;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * id : 1318525725518598145
             * nickname : hhh
             * mobile : 13189247675
             * avatar : https://yiyi-file.oss-cn-shenzhen.aliyuncs.com/user_avatar/%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F.jpg
             * sign : hhh
             */

            private String id;
            private String nickname;
            private String mobile;
            private String avatar;
            private String sign;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }
        }
    }
}
