package com.yc.yclibrary.net;

import com.hckj.steelbarinspection.exception.ApiException;
import com.hckj.steelbarinspection.exception.ErrorType;
import com.hckj.steelbarinspection.exception.ExceptionEngine;
import com.hckj.steelbarinspection.utils.NetworkUtil;
import com.hckj.steelbarinspection.utils.ToastUtil;
import com.orhanobut.logger.Logger;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 *
 */

public abstract class BaseObserver<T> implements Observer<T>, HttpRequest<T> {
    private Disposable disposable;

    //当订阅后，会首先调用这个方法，其实就相当于onStart()，
    //传入的Disposable d参数可以用于取消订阅
    @Override
    public void onSubscribe(@NonNull Disposable d) {
        disposable = d;
        if (!NetworkUtil.isNetworkAvailable()) {
            Logger.e("网络不可用");
            disposable.dispose();
        }
    }

    @Override
    public void onNext(@NonNull T response) {
        //防止闪退问题
        try {
            onSuccess(response);
        } catch (NullPointerException e) {
            e.printStackTrace();
            ToastUtil.show("网络异常！错误码:" + ErrorType.DATE_NULL);
        } catch (ApiException e) {
            e.printStackTrace();
            ToastUtil.show(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            ToastUtil.show("网络异常！错误码:" + ErrorType.UN_KNOWN_ERROR);
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        onFail(ExceptionEngine.handleException(e));
    }

    @Override
    public void onComplete() {
    }
}
