package com.yc.yclibrary.mvp;

import com.trello.rxlifecycle2.LifecycleTransformer;

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
}
