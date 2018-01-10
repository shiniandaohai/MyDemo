package com.mydemo.net;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by apple on 18/1/2.
 */

public class RetrofitServiceManager {
    private static final int DEFAULT_TIMEOUT=5;
    private static final int DEFAULT_READ_TIMEOUT= 10;
    private Retrofit retrofit;

    private RetrofitServiceManager(){
        OkHttpClient client = new OkHttpClient();
        OkHttpClient.Builder builder = client.newBuilder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(DEFAULT_READ_TIMEOUT,TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_READ_TIMEOUT,TimeUnit.SECONDS);
        builder.addInterceptor(new ReceivedCookiesInterceptor());
        builder.addInterceptor(new HttpCommonInterceptor());

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(AppUrl.URL_PREFIX)
                .build();
    }

    private static class SingleTonHolder{
        private static final RetrofitServiceManager INSTANCE = new RetrofitServiceManager();
    }

    public static RetrofitServiceManager getInstance(){
        return SingleTonHolder.INSTANCE;
    }

    /**
     * 获取对应的Service
     * @param  service Service 的 class
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service){
        return retrofit.create(service);
    }
}
