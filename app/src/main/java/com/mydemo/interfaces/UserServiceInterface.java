package com.mydemo.interfaces;

import com.mydemo.model.UserBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.Response;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by apple on 18/1/2.
 */

public interface UserServiceInterface {
    @FormUrlEncoded
    @POST("loginCheck.htm")
    Observable<UserBean> login(@FieldMap Map<String,String> map);
}
