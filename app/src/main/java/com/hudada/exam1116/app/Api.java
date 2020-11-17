package com.hudada.exam1116.app;

import com.hudada.exam1116.bean.KeyBean;
import com.hudada.exam1116.bean.LoginBean;
import com.hudada.exam1116.bean.RegisterBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("loginUser?apikey=68d331c45d579e99bb551f08aca6e6e5")
    Observable<LoginBean> Api_login(@Field("name") String name,@Field("passwd") String passwd);

    @FormUrlEncoded
    @POST("registerUser?apikey=68d331c45d579e99bb551f08aca6e6e5")
    Observable<RegisterBean> Api_register(@Field("name") String name,@Field("passwd") String passwd);

    @FormUrlEncoded
    @POST("developerRegister")
    Observable<KeyBean> Api_getApikey(@Field("name") String name, @Field("passwd") String passwd, @Field("email") String emil);
}
