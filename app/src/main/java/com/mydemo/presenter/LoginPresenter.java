package com.mydemo.presenter;

import android.content.Context;
import android.util.Log;

import com.mydemo.listener.BaseCallbackListener;
import com.mydemo.listener.LoginCallbackListener;
import com.mydemo.loader.user.UserLoader;
import com.mydemo.model.UserBean;
import com.mydemo.net.RxSchedulers;
import com.mydemo.utils.StaticParameter;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import okhttp3.Response;


/**
 * Created by apple on 18/1/4.
 */

public class LoginPresenter implements BasePresenter {
    private UserLoader userLoader;
    private LoginCallbackListener loginListener;
    private Context mContext;
    private UserBean userBean;
    private Disposable disposable;
    public LoginPresenter(Context context){
        this.mContext = context;
        userLoader = new UserLoader();
    }

    @Override
    public void attachListener(BaseCallbackListener listener) {
        loginListener = (LoginCallbackListener)listener;
    }

    @Override
    public void onDestroy() {
        if(disposable != null){
            disposable.dispose();
        }
    }

    public void isLogin(String name,String pwd){
        Map<String,String> map = new HashMap<>();
        map.put("call","1");
        map.put("userName",name);
        map.put("password",pwd);
        map.put("registrationId", StaticParameter.registrationID);

        userLoader.isLogin(map).compose(
                RxSchedulers.<UserBean>compose()
        ).subscribe(new Observer<UserBean>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(UserBean value) {
                loginListener.onSuccess(value);
            }

            @Override
            public void onError(Throwable e) {
                loginListener.onError(e.getCause());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
