package com.yangziling.mvpdemo.mvp.view;

import com.yangziling.mvpdemo.mvp.bean.User;

/**
 * <b>Create Date:</b> 2018/1/8<br>
 * <b>Author:</b> Stone <br>
 * <b>Description:</b> <br>
 */
public interface IUserLoginView {

    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void toMainActivity(User user);

    void showFailedError();
}
