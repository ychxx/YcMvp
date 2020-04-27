package com.yc.easycode;

import android.app.Application;

import com.yc.yclibrary.YcInit;

import io.reactivex.functions.Function;

/**
 *
 */

public class App extends Application {
    private Application mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        YcInit.setIsDebug(false);
        YcInit.init(this, UrlHelper.BASE_URL);
//        Function function = new Function<String, String>() {
//            @Override
//            public String apply(String o) throws Exception {
//                return "[{\"UserAccount\":\"admin\",\"UserName\":\"这是一个被拦截转换后的json\",\"UserId\":\"100039\"}]";
//            }
//        };
//        YcInit.setNetMap(function);
//        x.Ext.init(this);
//        x.Ext.setDebug(false); // 是否输出debug日志, 开启debug会影响性能.
    }
}
