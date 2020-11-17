package com.hudada.exam1116.bean;

public class KeyBean {

    /**
     * code : 200
     * message : 成功!
     * result : {"apikey":"68d331c45d579e99bb551f08aca6e6e5","email":null}
     */

    private int code;
    private String message;
    private ResultBean result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * apikey : 68d331c45d579e99bb551f08aca6e6e5
         * email : null
         */

        private String apikey;
        private Object email;

        public String getApikey() {
            return apikey;
        }

        public void setApikey(String apikey) {
            this.apikey = apikey;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }
    }
}
