package com.example.memoryeasy.model.domain;

import java.util.List;

public class ShowCardMsg {

    /**
     * success : true
     * code : 20000
     * message : 成功
     * data : {"totalCardType":0,"totalCard":91,"items":[]}
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
         * totalCardType : 0
         * totalCard : 91
         * items : []
         */

        private Integer totalCardType;
        private Integer totalCard;
        private List<?> items;

        public Integer getTotalCardType() {
            return totalCardType;
        }

        public void setTotalCardType(Integer totalCardType) {
            this.totalCardType = totalCardType;
        }

        public Integer getTotalCard() {
            return totalCard;
        }

        public void setTotalCard(Integer totalCard) {
            this.totalCard = totalCard;
        }

        public List<?> getItems() {
            return items;
        }

        public void setItems(List<?> items) {
            this.items = items;
        }
    }
}
