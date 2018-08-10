package com.yc.yclibrary;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.yc.yclibrary.net.RetrofitUtils;


/**
 * 初始化
 */

public class YcInit {
    private static Application mApplication;
    public static final String OTHER_BASE_URL = "other_base_url";//用于切换url的标示
    public static String mBaseUrl = "";
    private static final String TAG = "YcInit";

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
}
