package com.yc.yclibrary;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.yc.yclibrary.net.RetrofitUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;
import okhttp3.Interceptor;
import retrofit2.Converter;


/**
 * 初始化
 */

public class YcInit {
    private static Application mApplication;
    private static final String TAG = "YcInit";
    private static final List<Interceptor> mInterceptors = new ArrayList<>();
    public static final String OTHER_BASE_URL = "other_base_url";//用于切换url的标示
    public static final String OTHER_INTERCEPTOR = "other_interceptor";//用于请求拦截和响应数据拦截的标示
    public static String mBaseUrl = "";
    private static boolean mIsDebug = false;//是否是调试模式
    private static int mConnectTime = 180;//连接超时时长x秒
    private static int mReadTime = 180;//读数据超时时长x秒
    private static int mWriteTime = 180;//写数据接超时时长x秒
    private static boolean mIsShowNetLog = true;//是否是打印网络请求的log
    private static Converter.Factory mGsonFactory;

    public static void setIsShowNetLog(boolean isShowNetLog) {
        YcInit.mIsShowNetLog = isShowNetLog;
    }

    public static boolean isShowNetLog() {
        return mIsShowNetLog;
    }

    public static void init(Application application, String baseUrl) {
        if (TextUtils.isEmpty(baseUrl)) {
            Log.e(TAG, "传入的baseUrl为空，会导致网络请问相关功能无法正常使用");
        } else {
            mBaseUrl = baseUrl;
        }
        if (mApplication == null) {
            mApplication = application;
            //logger日志的初始化
            Logger.addLogAdapter(new AndroidLogAdapter());
        } else {
            Log.e(TAG, "YcInit.init()传入的application为空");
        }
    }

    /**
     * 获取创建Retrofit
     *
     * @param service
     * @param <T>
     * @return
     */
    public static <T> T getApiService(final Class<T> service) {
        return RetrofitUtils.Instance.getApiService(service);
    }

    public static Context getContext() {
        return mApplication;
    }

    public static boolean isIsDebug() {
        return mIsDebug;
    }

    public static void setIsDebug(boolean mIsDebug) {
        YcInit.mIsDebug = mIsDebug;
    }

    public static int getConnectTime() {
        return mConnectTime;
    }

    public static int getReadTime() {
        return mReadTime;
    }

    public static int getWriteTime() {
        return mWriteTime;
    }

    public static void setConnectTime(int connectTime) {
        YcInit.mConnectTime = connectTime;
    }

    public static void setReadTime(int readTime) {
        YcInit.mReadTime = readTime;
    }

    public static void setWriteTime(int writeTime) {
        YcInit.mWriteTime = writeTime;
    }

    public static void addInterceptors(Interceptor interceptor) {
        mInterceptors.add(interceptor);
    }

    public static List<Interceptor> getInterceptors() {
        return mInterceptors;
    }

    public static Converter.Factory getGsonFactory() {
        return mGsonFactory;
    }

    public static void setGsonFactory(Converter.Factory gsonFactory) {
        mGsonFactory = gsonFactory;
    }
}
