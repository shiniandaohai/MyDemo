package com.mydemo.presenter;

import com.mydemo.listener.BaseCallbackListener;

/**
 * Created by apple on 18/1/3.
 */

public interface BasePresenter {

    //连接listener与activity
    void attachListener(BaseCallbackListener listener);

    /**
     * 当页面销毁的时候，需要把view = null;
     * 然后调用system.gc()
     */
    void onDestroy();
}
