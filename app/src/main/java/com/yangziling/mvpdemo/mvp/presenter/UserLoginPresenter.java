package com.yangziling.mvpdemo.mvp.presenter;

import android.os.Handler;
import android.util.Log;

import com.yangziling.mvpdemo.mvp.bean.User;
import com.yangziling.mvpdemo.mvp.biz.IUserBiz;
import com.yangziling.mvpdemo.mvp.biz.OnLoginLinstener;
import com.yangziling.mvpdemo.mvp.biz.UserBiz;
import com.yangziling.mvpdemo.mvp.view.IUserLoginView;

/**
 * <b>Create Date:</b> 2018/1/8<br>
 * <b>Author:</b> Stone <br>
 * <b>Description:</b>处理Activity业务逻辑<br>
 */
public class UserLoginPresenter {

    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }
    /**
     * 登陆操作
     */
    public void login(){
        Log.d("====",userLoginView.getUserName().toString()+"\n"+userLoginView.getPassword().toString());
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginLinstener() {
            @Override
            public void loginSuccess(final User user) {
                //模拟UI线程操作
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                    }
                });
            }

            @Override
            public void loginFaiture() {
                //登陆失败回调接口
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                    }
                });
            }
        });
    }

    public void clear(){
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}
