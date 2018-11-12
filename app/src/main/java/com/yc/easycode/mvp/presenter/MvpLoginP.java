package com.yc.easycode.mvp.presenter;

import com.yc.easycode.bean.json.LoginJson;
import com.yc.easycode.mvp.contact.MvpLoginC;
import com.yc.easycode.mvp.model.MvpLoginM;
import com.yc.yclibrary.exception.ApiException;
import com.yc.yclibrary.mvp.BasePresenter;
import com.yc.yclibrary.net.BaseObserver;

import java.util.List;

import io.reactivex.functions.Action;

/**
 *
 */

public class MvpLoginP extends BasePresenter<MvpLoginC.V> implements MvpLoginC.P {
    @Override
    @SuppressWarnings("unchecked")
    public void login(String userName, String userPassword) {
        new MvpLoginM()
                .login(userName, userPassword)
                .compose(getIView().bindLifecycle())
                .doOnSubscribe((disposable) -> getIView().showLoading("加载中..."))
                .doFinally(() -> getIView().hideLoading())
                .subscribe(new BaseObserver<List<LoginJson>>() {
                    @Override
                    public void onSuccess(List<LoginJson> json) {
                        getIView().onLoginSuccess(json.get(0));
                    }

                    @Override
                    public void onFail(ApiException msg) {
                        getIView().onLoginFail(msg);
                    }
                });
    }
}
