package com.mydemo.net;

import android.text.TextUtils;

import com.mydemo.utils.StaticParameter;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by apple on 18/1/3.
 */

public class HttpCommonInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        builder.addHeader("Accept-Charset","utf-8");
        String cookie = StaticParameter.cookie;
        if(!TextUtils.isEmpty(cookie))
            builder.addHeader("Cookie",cookie);
        return chain.proceed(builder.build());
    }

}
