package com.yc.yclibrary.mvp;

/**
 * ================================================
 * 框架中的每个 Presenter 都需要实现此类,以满足规范
 * ================================================
 */

public interface IPresenter<V extends IView> {
    void attachView(V view);

    V getIView();

    void detachView();
}
