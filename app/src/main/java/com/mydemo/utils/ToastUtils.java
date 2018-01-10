package com.mydemo.utils;

import android.widget.Toast;

import com.mydemo.MyApplication;

/**
 * Created by apple on 18/1/5.
 */

public class ToastUtils {
    private static Toast toast;
    /**
     * Using Toast way pop-up messages (display 3 seconds)
     *
     * @Title: showLongMsg
     * @param msg
     */
    public static void showLongMsg(String msg) {
        if (toast == null) {
            toast = Toast.makeText(MyApplication.getApplication(), msg,
                    Toast.LENGTH_LONG);
        }else {
            toast.setText(msg);
        }
        toast.show();
    }

    /**
     * Using Toast way pop-up messages (display 2 seconds)
     *
     * @Title: showShortMsg
     * @param msg
     */
    public static void showShortMsg(String msg) {
        if (toast == null) {
            toast = Toast.makeText(MyApplication.getApplication(), msg,
                    Toast.LENGTH_SHORT);
        }else {
            toast.setText(msg);
        }
        toast.show();
    }
}
