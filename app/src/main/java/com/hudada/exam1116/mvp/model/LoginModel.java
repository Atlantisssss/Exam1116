package com.hudada.exam1116.mvp.model;

import com.hudada.exam1116.app.Api;
import com.hudada.exam1116.bean.LoginBean;
import com.hudada.exam1116.http.RetrofitHttpManager;
import com.hudada.exam1116.mvp.contract.LoginContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginModel implements LoginContract.loginModel {
    @Override
    public void loginmodel_(Observer<LoginBean> observer, String name, String pwd) {
        RetrofitHttpManager.getManager().getRetrofit()
                .create(Api.class)
                .Api_login(name,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void destroy() {

    }
}
