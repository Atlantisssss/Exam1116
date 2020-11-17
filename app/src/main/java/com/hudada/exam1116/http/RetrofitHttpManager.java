package com.hudada.exam1116.http;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHttpManager {
    public static RetrofitHttpManager manager;
    public static synchronized  RetrofitHttpManager getManager(){
        if(manager==null){
            manager=new RetrofitHttpManager();
        }
        return manager;
    }
    public Retrofit retrofit;
    public Retrofit getRetrofit(){
        if(retrofit==null){
            createRetrofit();
        }
        return retrofit;
    }

    private void createRetrofit() {
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder=new OkHttpClient.Builder()
                .addInterceptor(interceptor);
        Retrofit.Builder builder1=new Retrofit.Builder()
                .baseUrl("https://api.apiopen.top/")
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        retrofit=builder1.build();
    }
}
