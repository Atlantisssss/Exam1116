package com.hudada.exam1116.mvp.model;

import com.hudada.exam1116.app.Api;
import com.hudada.exam1116.bean.KeyBean;
import com.hudada.exam1116.bean.RegisterBean;
import com.hudada.exam1116.http.RetrofitHttpManager;
import com.hudada.exam1116.mvp.contract.RegisterContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RegisterModel implements RegisterContract.register_model {
    @Override
    public void loginmodel_(Observer<KeyBean> observer, String name, String pwd, String emil) {
        RetrofitHttpManager.getManager().getRetrofit()
                .create(Api.class)
                .Api_getApikey(name,pwd,emil)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void destroy() {

    }
}
