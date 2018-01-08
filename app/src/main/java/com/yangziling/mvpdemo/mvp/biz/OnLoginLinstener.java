package com.yangziling.mvpdemo.mvp.biz;

import com.yangziling.mvpdemo.mvp.bean.User;

/**
 * <b>Create Date:</b> 2018/1/8<br>
 * <b>Author:</b> Stone <br>
 * <b>Description:</b> <br>
 */
public interface OnLoginLinstener {

    void loginSuccess(User user);
    void loginFaiture();
}
