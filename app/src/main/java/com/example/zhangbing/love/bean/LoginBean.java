package com.example.zhangbing.love.bean;

/**
 * 创建时间: 2017/9/30.
 * 编写人:
 * 功能描述:
 */

public class LoginBean {


    /**
     * data : {"userName":"zhangbing","userRealName":"章冰","accountType":3,"sex":1,"isCompany":0,"email":"314835006@qq.com","isTeacher":0,"password":"e10adc3949ba59abbe56e057f20f883e","serialNum":"1400000015","token":"B8C4E514D185E3C76FA96EFCE4AE9974","state":1,"crtUser":"admin","crtTime":"2017-09-28 09:43:28","updTime":"2017-09-30 11:35:01","crtIp":"127.0.0.1","id":"ddac17af-fbf1-4879-9a07-2c4ff09903ec"}
     * code : 1
     */

    private DataBean data;
    private String code;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class DataBean {
        /**
         * userName : zhangbing
         * userRealName : 章冰
         * accountType : 3
         * sex : 1
         * isCompany : 0
         * email : 314835006@qq.com
         * isTeacher : 0
         * password : e10adc3949ba59abbe56e057f20f883e
         * serialNum : 1400000015
         * token : B8C4E514D185E3C76FA96EFCE4AE9974
         * state : 1
         * crtUser : admin
         * crtTime : 2017-09-28 09:43:28
         * updTime : 2017-09-30 11:35:01
         * crtIp : 127.0.0.1
         * id : ddac17af-fbf1-4879-9a07-2c4ff09903ec
         */

        private String userName;
        private String userRealName;
        private int accountType;
        private int sex;
        private int isCompany;
        private String email;
        private int isTeacher;
        private String password;
        private String serialNum;
        private String token;
        private int state;
        private String crtUser;
        private String crtTime;
        private String updTime;
        private String crtIp;
        private String id;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserRealName() {
            return userRealName;
        }

        public void setUserRealName(String userRealName) {
            this.userRealName = userRealName;
        }

        public int getAccountType() {
            return accountType;
        }

        public void setAccountType(int accountType) {
            this.accountType = accountType;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getIsCompany() {
            return isCompany;
        }

        public void setIsCompany(int isCompany) {
            this.isCompany = isCompany;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getIsTeacher() {
            return isTeacher;
        }

        public void setIsTeacher(int isTeacher) {
            this.isTeacher = isTeacher;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getSerialNum() {
            return serialNum;
        }

        public void setSerialNum(String serialNum) {
            this.serialNum = serialNum;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getCrtUser() {
            return crtUser;
        }

        public void setCrtUser(String crtUser) {
            this.crtUser = crtUser;
        }

        public String getCrtTime() {
            return crtTime;
        }

        public void setCrtTime(String crtTime) {
            this.crtTime = crtTime;
        }

        public String getUpdTime() {
            return updTime;
        }

        public void setUpdTime(String updTime) {
            this.updTime = updTime;
        }

        public String getCrtIp() {
            return crtIp;
        }

        public void setCrtIp(String crtIp) {
            this.crtIp = crtIp;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "userName='" + userName + '\'' +
                    ", userRealName='" + userRealName + '\'' +
                    ", accountType=" + accountType +
                    ", sex=" + sex +
                    ", isCompany=" + isCompany +
                    ", email='" + email + '\'' +
                    ", isTeacher=" + isTeacher +
                    ", password='" + password + '\'' +
                    ", serialNum='" + serialNum + '\'' +
                    ", token='" + token + '\'' +
                    ", state=" + state +
                    ", crtUser='" + crtUser + '\'' +
                    ", crtTime='" + crtTime + '\'' +
                    ", updTime='" + updTime + '\'' +
                    ", crtIp='" + crtIp + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "data=" + data +
                ", code='" + code + '\'' +
                '}';
    }
}
