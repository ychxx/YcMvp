package com.yc.yclibrary.mvp;

import android.support.annotation.NonNull;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.yc.yclibrary.bean.BindEvent;

/**
 * mvp之v
 */

public interface IView {
    /**
     * 显示加载
     */
    void showLoading(String msg);

    /**
     * 隐藏加载
     */
    void hideLoading();
    /**
     * 显示信息
     */
    void showMsg(String msg);

    LifecycleTransformer bindLifecycle();
    LifecycleTransformer bindLifecycle(@BindEvent int event);
}
