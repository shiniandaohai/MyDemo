package com.mydemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by apple on 18/1/2.
 */

public class MyApplication extends Application {
    private static MyApplication application = null;
    public static MyApplication getInstance(){
        return application;
    }
    public static Context getApplication(){
        return application;
    }

    @Override
    public void onCreate() {
        application = this;
    }
}
