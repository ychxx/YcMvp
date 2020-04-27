package com.yc.easycode.mvp.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.yc.easycode.ApiServer;
import com.yc.easycode.bean.json.LoginJson;
import com.yc.easycode.bean.json.TestLogJson;
import com.yc.easycode.mvp.contact.MvpLoginC;
import com.yc.easycode.mvp.model.MvpLoginM;
import com.yc.yclibrary.exception.ApiException;
import com.yc.yclibrary.mvp.BasePresenter;
import com.yc.yclibrary.net.BaseObserver;
import com.yc.yclibrary.net.NetTransformer;
import com.yc.yclibrary.net.RetrofitUtils;

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

    public void uploadImg(String userName, String userPassword) {
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

    public void test() {
        RetrofitUtils.Instance
                .getApiService(ApiServer.class)
                .testLog("53A379CD7474EA7D9012BE279D5FBEB2", "hckj2018", "test1111", "json",
                        "login", "Z2V5ZUAyMDE4IQ==", "md5", "2019-08-29 16:08:43", "2.0")
                .compose(NetTransformer.compose())
                .compose(getIView().bindLifecycle())
                .doOnSubscribe((disposable) -> getIView().showLoading("加载中..."))
                .doFinally(() -> getIView().hideLoading())
                .subscribe(new BaseObserver<TestLogJson>() {
                    @Override
                    public void onSuccess(TestLogJson json) {
                        getIView().showMsg("成功");
                    }

                    @Override
                    public void onFail(ApiException msg) {
                        getIView().onLoginFail(msg);
                    }
                });
    }
}
