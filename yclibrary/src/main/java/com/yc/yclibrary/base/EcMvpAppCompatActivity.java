package com.yc.yclibrary.base;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.yc.yclibrary.mvp.BasePresenter;
import com.yc.yclibrary.mvp.IView;

/**
 *
 */

public abstract class EcMvpAppCompatActivity<P extends BasePresenter> extends EcAppCompatActivity implements IView {
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

}
