package com.mydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mydemo.activity.BaseMvpActivity;
import com.mydemo.activity.LoginActivity;
import com.mydemo.listener.LoginCallbackListener;
import com.mydemo.presenter.BasePresenter;
import com.mydemo.presenter.LoginPresenter;
import com.mydemo.utils.StaticParameter;

public class MainActivity extends BaseMvpActivity {
    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

}
