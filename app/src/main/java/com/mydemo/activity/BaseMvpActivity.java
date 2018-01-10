package com.mydemo.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.mydemo.listener.BaseCallbackListener;
import com.mydemo.presenter.BasePresenter;

public abstract class BaseMvpActivity extends Activity{
    private BasePresenter presenter;
    public Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        mContext = this;
        presenter = bindPresenter();
        initView();
        initData();
    }

    /**
     * 返回资源的布局
     *
     * @return
     */
    public abstract int getLayoutResId();

    /**
     * 组件初始化操作
     */
    public abstract void initView();

    /**
     * 页面初始化页面数据，在initView之后调用
     */
    public abstract void initData();

    /**
     * 绑定presenter，主要用于销毁工作
     *
     * @return
     */
    protected abstract BasePresenter bindPresenter();

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(presenter != null){
            presenter.onDestroy();
            presenter = null;
            System.gc();
        }
    }
}
