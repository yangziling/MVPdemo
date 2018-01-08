package com.yangziling.mvpdemo.mvp.bean;

/**
 * <b>Create Date:</b> 2018/1/8<br>
 * <b>Author:</b> Stone <br>
 * <b>Description:</b> <br>
 */
public class User {

    private String UserName;
    private String psw;

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPsw() {
        return psw;
    }

    public User() {
    }

    public User(String userName, String psw) {
        UserName = userName;
        this.psw = psw;
    }
}
