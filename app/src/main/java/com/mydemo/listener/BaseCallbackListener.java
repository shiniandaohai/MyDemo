package com.mydemo.listener;

/**
 * Created by apple on 18/1/3.
 * 公共回调监听
 */

public interface BaseCallbackListener<T> {
    //当任务成功的时候回调
    void onSuccess(T result);

    //当任务执行过程中出错的时候回调
    void onError(Throwable errorMsg);
    void onError(String errorMsg);
}
