package com.yc.easycode.mvp.presenter;

import com.yc.easycode.bean.json.LoginJson;
import com.yc.easycode.mvp.contact.MvpLoginC;
import com.yc.easycode.mvp.model.MvpLoginM;
import com.yc.yclibrary.exception.ApiException;
import com.yc.yclibrary.mvp.BasePresenter;
import com.yc.yclibrary.net.BaseObserver;

import java.util.List;

/**
 *
 */

public class MvpLoginP extends BasePresenter<MvpLoginC.V> implements MvpLoginC.P {
    @Override
    public void login(String userName, String userPassword) {
        getIView().showLoading("加载中...");
        new MvpLoginM().login(userName, userPassword)
                .compose(getIView().bindLifecycle())
                .subscribe(new BaseObserver<List<LoginJson>>() {
                    @Override
                    public void onSuccess(List<LoginJson> json) {
                        getIView().hideLoading();
                        getIView().onLoginSuccess(json.get(0));
                    }

                    @Override
                    public void onFail(ApiException msg) {
                        getIView().hideLoading();
                        getIView().onLoginFail(msg);
                    }
                });
    }
}
