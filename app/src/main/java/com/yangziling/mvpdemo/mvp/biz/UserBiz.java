package com.yangziling.mvpdemo.mvp.biz;

import com.yangziling.mvpdemo.mvp.bean.User;

/**
 * <b>Create Date:</b> 2018/1/8<br>
 * <b>Author:</b> Stone <br>
 * <b>Description:</b> <br>
 */
public class UserBiz implements IUserBiz{


    @Override
    public void login(final String username, final String password, final OnLoginLinstener loginListener) {
        //模拟耗时操作
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //登陆成功
                if ("yzl".equals(username)&&"111".equals(password)){
                    User user = new User();
                    user.setUserName(username);
                    user.setPsw(password);
                    loginListener.loginSuccess(user);
                }else {
                    //登陆失败
                    loginListener.loginFaiture();
                }
            }

        }.start();
    }
}
