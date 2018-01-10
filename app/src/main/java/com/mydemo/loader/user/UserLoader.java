package com.mydemo.loader.user;

import com.mydemo.interfaces.UserServiceInterface;
import com.mydemo.loader.ObjectLoader;
import com.mydemo.model.UserBean;
import com.mydemo.net.RetrofitServiceManager;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import okhttp3.Response;


/**
 * Created by apple on 18/1/2.
 */

public class UserLoader {
    private UserServiceInterface userService;
    public UserLoader(){
        userService = RetrofitServiceManager.getInstance().create(UserServiceInterface.class);
    }

    public Observable<UserBean> isLogin(Map<String,String> maps){
       /* return observe(userService.login(maps))
                .map(new Function<UserBean, UserBean>() {
                    @Override
                    public UserBean apply(UserBean userBean) throws Exception {
                        return userBean;
                    }
                });*/
        return userService.login(maps);
    }
}
