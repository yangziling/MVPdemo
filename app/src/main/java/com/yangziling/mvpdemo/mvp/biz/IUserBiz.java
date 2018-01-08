package com.yangziling.mvpdemo.mvp.biz;

/**
 * <b>Create Date:</b> 2018/1/8<br>
 * <b>Author:</b> Stone <br>
 * <b>Description:</b> <br>
 */
public interface IUserBiz {

     void login(String username, String password, OnLoginLinstener loginListener);
}
