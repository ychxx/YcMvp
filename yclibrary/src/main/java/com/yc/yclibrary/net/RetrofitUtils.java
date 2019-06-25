package com.yc.yclibrary.net;


import com.yc.yclibrary.YcInit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * retrofit工具类
 */

public enum RetrofitUtils {
    Instance();

    private Retrofit mRetrofit;

    private RetrofitUtils() {
        mRetrofit = createRetrofit();
    }

    private Retrofit createRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor())//使用interceptors会导致header中的cookie等信息不会打印出来
//                .addNetworkInterceptor(new LogInterceptor())//添加日志拦截器，打印日志
                .connectTimeout(YcInit.getConnectTime(), TimeUnit.SECONDS)
                .writeTimeout(YcInit.getWriteTime(), TimeUnit.SECONDS)
                .readTimeout(YcInit.getReadTime(), TimeUnit.SECONDS)
                .build();
        return new Retrofit.Builder()
                .baseUrl(YcInit.mBaseUrl)
                .client(client)
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    private Retrofit getRetrofit() {
        if (mRetrofit == null) {
            mRetrofit = createRetrofit();
        }
        return mRetrofit;
    }

    public <T> T getApiService(final Class<T> service) {
        return getRetrofit().create(service);
    }
//    public Class<?> getApiService() {
//        return getRetrofit().create(apiService);
//    }
//    private Class apiService = null;
//
//    public void setServiceClass(Class serviceClass) {
//        apiService = serviceClass;
//    }
}
