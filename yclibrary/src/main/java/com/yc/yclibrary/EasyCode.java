package com.yc.yclibrary;

import android.app.Application;

/**
 * 初始依赖包
 */

public class EasyCode {
    private static Application mApplication;

    public static void init(Application application) {
        mApplication = application;
    }
}
