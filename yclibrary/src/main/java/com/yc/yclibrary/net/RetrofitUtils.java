package com.yc.yclibrary.net;



import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 *  retrofit工具类
 */

public enum RetrofitUtils {
    Instance();
    private static final int CONNECT_TIME_OUT = 180;//连接超时时长x秒
    private static final int READ_TIME_OUT = 180;//读数据超时时长x秒
    private static final int WRITE_TIME_OUT = 180;//写数据接超时时长x秒

    private Retrofit getRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor())//使用interceptors会导致header中的cookie等信息不会打印出来
//                .addNetworkInterceptor(new LogInterceptor())//添加日志拦截器，打印日志
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .build();
        return new Retrofit.Builder()
                .baseUrl(UrlHelper.BASE_URL)
                .client(client)
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public ApiService getApiService() {
        return getRetrofit().create(ApiService.class);
    }
}
