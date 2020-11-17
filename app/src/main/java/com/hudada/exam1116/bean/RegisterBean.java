package com.hudada.exam1116.bean;

public class RegisterBean {
    /**
     * code : 200
     * message : 成功!
     * result : {"name":"peakchaos","nikeName":null,"headerImg":null,"phone":null,"email":null,"vipGrade":null,"autograph":null,"remarks":null}
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
         * name : peakchaos
         * nikeName : null
         * headerImg : null
         * phone : null
         * email : null
         * vipGrade : null
         * autograph : null
         * remarks : null
         */

        private String name;
        private Object nikeName;
        private Object headerImg;
        private Object phone;
        private Object email;
        private Object vipGrade;
        private Object autograph;
        private Object remarks;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getNikeName() {
            return nikeName;
        }

        public void setNikeName(Object nikeName) {
            this.nikeName = nikeName;
        }

        public Object getHeaderImg() {
            return headerImg;
        }

        public void setHeaderImg(Object headerImg) {
            this.headerImg = headerImg;
        }

        public Object getPhone() {
            return phone;
        }

        public void setPhone(Object phone) {
            this.phone = phone;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getVipGrade() {
            return vipGrade;
        }

        public void setVipGrade(Object vipGrade) {
            this.vipGrade = vipGrade;
        }

        public Object getAutograph() {
            return autograph;
        }

        public void setAutograph(Object autograph) {
            this.autograph = autograph;
        }

        public Object getRemarks() {
            return remarks;
        }

        public void setRemarks(Object remarks) {
            this.remarks = remarks;
        }
    }
}
