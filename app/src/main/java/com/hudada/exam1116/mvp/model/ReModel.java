package com.hudada.exam1116.mvp.model;

import com.hudada.exam1116.app.Api;
import com.hudada.exam1116.bean.RegisterBean;
import com.hudada.exam1116.http.RetrofitHttpManager;
import com.hudada.exam1116.mvp.contract.ReContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ReModel implements ReContract.register_model {
    @Override
    public void loginmodel_(Observer<RegisterBean> observer, String name, String pwd) {
        RetrofitHttpManager.getManager().getRetrofit()
                .create(Api.class)
                .Api_register(name,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void destroy() {

    }
}
