package com.yc.yclibrary.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.yc.yclibrary.bean.BindEvent;
import com.yc.yclibrary.mvp.BasePresenter;
import com.yc.yclibrary.mvp.IView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 *
 */

public abstract class YcMvpLazyFragment<P extends BasePresenter> extends YcLazyFragment implements IView {
    protected P mPresenter;
    protected ProgressDialog mProgressDialog = null;
    protected Disposable mDisposableLoad;
    /**
     * 加载框延迟显示时间
     */
    protected int mLoadDelayTime = 1500;

    /**
     * 加载Presenter
     */
    protected abstract P loadPresenter();

    @Override
    public void onAttach(Activity activity) {
        mPresenter = loadPresenter();
        if (mPresenter != null)
            mPresenter.attachView(this);
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        if (mDisposableLoad != null) {
            mDisposableLoad.dispose();
        }
        super.onDetach();
    }

    /**
     * 显示加载框
     */
    @Override
    public void showLoading(String msg) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setCancelable(false);
            mProgressDialog.setCanceledOnTouchOutside(false);
        }
        if (!mProgressDialog.isShowing()) {
            if (mDisposableLoad != null) {
                mDisposableLoad.dispose();
            }
            mDisposableLoad = Observable.timer(mLoadDelayTime, TimeUnit.MILLISECONDS)
                    .observeOn(AndroidSchedulers.mainThread())//下游
                    .subscribe(aLong -> {
                        mProgressDialog.setMessage(msg);
                        mProgressDialog.show();
                    });
        }
    }

    /**
     * 隐藏加载框
     */
    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }


    /**
     * 用于绑定bindLifecycle
     */
    @Override
    public LifecycleTransformer bindLifecycle() {
        return super.bindToLifecycle();
    }

    @Override
    public LifecycleTransformer bindLifecycle(@BindEvent int event) {
        switch (event) {
            case BindEvent.ATTACH:
                return super.bindUntilEvent(FragmentEvent.ATTACH);
            case BindEvent.CREATE:
                return super.bindUntilEvent(FragmentEvent.CREATE);
            case BindEvent.CREATE_VIEW:
                return super.bindUntilEvent(FragmentEvent.CREATE_VIEW);
            case BindEvent.START:
                return super.bindUntilEvent(FragmentEvent.START);
            case BindEvent.RESUME:
                return super.bindUntilEvent(FragmentEvent.RESUME);
            case BindEvent.PAUSE:
                return super.bindUntilEvent(FragmentEvent.PAUSE);
            case BindEvent.STOP:
                return super.bindUntilEvent(FragmentEvent.STOP);
            case BindEvent.DESTROY_VIEW:
                return super.bindUntilEvent(FragmentEvent.DESTROY_VIEW);
            case BindEvent.DESTROY:
                return super.bindUntilEvent(FragmentEvent.DESTROY);
            case BindEvent.DETACH:
                return super.bindUntilEvent(FragmentEvent.DETACH);
            default:
                return super.bindToLifecycle();
        }
    }

    @Override
    public void showMsg(String msg) {
        showToast(msg);
    }
}