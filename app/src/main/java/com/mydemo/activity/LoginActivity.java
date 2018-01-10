package com.mydemo.activity;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mydemo.R;
import com.mydemo.listener.LoginCallbackListener;
import com.mydemo.presenter.BasePresenter;
import com.mydemo.presenter.LoginPresenter;
import com.mydemo.utils.ToastUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class LoginActivity extends BaseMvpActivity {
    //@InjectView(R.id.etname)
    EditText etname;
    @InjectView(R.id.etpwd)
    EditText etpwd;
    @InjectView(R.id.activity_login)
    ConstraintLayout activityLogin;
    private Button btnlogin;
    private LoginPresenter loginPresenter;
    private String name;
    private String pwd;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        ButterKnife.inject(this);
        etname = (EditText) findViewById(R.id.etname);
        btnlogin = (Button)findViewById(R.id.btn_login);
    }

    @Override
    public void initData() {
        loginPresenter = new LoginPresenter(this);
        loginPresenter.attachListener(listener);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = etname.getText().toString().trim();
                pwd = etpwd.getText().toString();
                if(!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(pwd)) {
                    loginPresenter.isLogin(name,pwd);
                }else {
                    ToastUtils.showShortMsg("账号或密码不能为空");
                }
            }
        });
    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //loginPresenter.onDestroy();
    }

    private LoginCallbackListener listener = new LoginCallbackListener() {
        @Override
        public void onSuccess(Object result) {
            ToastUtils.showShortMsg("拿到数据了");
        }

        @Override
        public void onError(Throwable errorMsg) {
            ToastUtils.showShortMsg(errorMsg.getMessage().toString());
        }

        @Override
        public void onError(String errorMsg) {

        }
    };

}
