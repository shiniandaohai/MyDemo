package com.mydemo.net;

import com.mydemo.utils.StaticParameter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by apple on 18/1/2.
 * 获取并保存cookies
 */

public class ReceivedCookiesInterceptor implements Interceptor{
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        //set-cookie可能有多个
        if(!response.headers("set-cookie").isEmpty()){
            List<String> cookies = response.headers("set-cookie");
            String cookie = encodeCookie(cookies);
            StaticParameter.cookie = cookie;
        }
        return response;
    }

    //整合cookie为唯一字符串
    private String encodeCookie(List<String> cookies){
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        for(String cookie:cookies){
            String[] arr = cookie.split(";");
            for(String s:arr){
                if(set.contains(s))
                    continue;
                set.add(s);
            }
        }
        Iterator<String> ite = set.iterator();
        while (ite.hasNext()){
            String cookie = ite.next();
            sb.append(cookie).append(";");
        }

        int last = sb.lastIndexOf(";");
        if(sb.length()-1 == last){
            sb.deleteCharAt(last);
        }

        return sb.toString();
    }
}
