package com.yc.yclibrary.mvp;
import java.lang.ref.WeakReference;

/**
 * 基类 Presenter
 */

public class BasePresenter<V extends IView> implements IPresenter<V> {
    //使用弱引用,避免内存泄漏
    private WeakReference<V> actReference;

    @Override
    public void attachView(V view) {
        actReference = new WeakReference<V>(view);
    }

    public V getIView() {
        return actReference.get();
    }

    /**
     * 断开与View模型的连接，类型于Activity与Fragment的断开ondeTachActivity()
     * 防止“死后鞭尸”
     */
    @Override
    public void detachView() {
        if (actReference != null) {
            actReference.clear();
            actReference = null;
        }
    }
}
