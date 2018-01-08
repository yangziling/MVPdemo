package com.yangziling.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.yangziling.mvpdemo.mvp.bean.User;
import com.yangziling.mvpdemo.mvp.presenter.UserLoginPresenter;
import com.yangziling.mvpdemo.mvp.view.IUserLoginView;

public class MainActivity extends AppCompatActivity implements IUserLoginView {

    private EditText mUsername, mPwd;
    private Button mLogin, mClear;
    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    //初始化控件
    private void initViews() {
        mUsername = (EditText) findViewById(R.id.username);
        mPwd = (EditText) findViewById(R.id.psw);


        mLogin = (Button) findViewById(R.id.login);
        mClear = (Button) findViewById(R.id.clear);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.login();
            }
        });
        mClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.clear();
            }
        });

    }

    @Override
    public String getUserName() {
        return mUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mPwd.getText().toString();
    }

    @Override
    public void clearUserName() {
        mUsername.setText("");
    }

    @Override
    public void clearPassword() {
        mPwd.setText("");
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUserName() +
                             " login success ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,
                       "login failed", Toast.LENGTH_SHORT).show();
    }

}
