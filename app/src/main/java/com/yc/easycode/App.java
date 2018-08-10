package com.yc.easycode;

import android.app.Application;

import com.yc.yclibrary.YcInit;

/**
 *
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        YcInit.init(this,UrlHelper.BASE_URL);
//        x.Ext.init(this);
//        x.Ext.setDebug(false); // 是否输出debug日志, 开启debug会影响性能.
    }
}
