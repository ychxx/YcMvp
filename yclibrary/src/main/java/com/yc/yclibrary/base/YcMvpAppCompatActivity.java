package com.yc.yclibrary.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.RxActivity;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yc.yclibrary.bean.BindEvent;
import com.yc.yclibrary.mvp.BasePresenter;
import com.yc.yclibrary.mvp.IView;

/**
 *
 */

public abstract class YcMvpAppCompatActivity<P extends BasePresenter> extends YcAppCompatActivity implements IView {
    protected P mPresenter;
    private ProgressDialog mProgressDialog = null;

    /**
     * 加载Presenter
     */
    protected abstract P loadPresenter();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mPresenter = loadPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
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
            mProgressDialog.setMessage(msg);
            mProgressDialog.show();
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

    @Override
    public void showMsg(String msg) {
        showToast(msg);
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
            case BindEvent.CREATE:
                return super.bindUntilEvent(ActivityEvent.CREATE);
            case BindEvent.START:
                return super.bindUntilEvent(ActivityEvent.START);
            case BindEvent.RESUME:
                return super.bindUntilEvent(ActivityEvent.RESUME);
            case BindEvent.PAUSE:
                return super.bindUntilEvent(ActivityEvent.PAUSE);
            case BindEvent.STOP:
                return super.bindUntilEvent(ActivityEvent.STOP);
            case BindEvent.DESTROY:
                return super.bindUntilEvent(ActivityEvent.DESTROY);
            case BindEvent.ATTACH:
            case BindEvent.CREATE_VIEW:
            case BindEvent.DESTROY_VIEW:
            case BindEvent.DETACH:
            default:
                return super.bindToLifecycle();
        }
    }
}
