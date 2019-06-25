package com.yc.yclibrary.net;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.orhanobut.logger.Logger;
import com.yc.yclibrary.YcInit;
import com.yc.yclibrary.base.YcAppCompatActivity;
import com.yc.yclibrary.exception.ApiException;
import com.yc.yclibrary.exception.ErrorType;
import com.yc.yclibrary.exception.ExceptionEngine;
import com.yc.yclibrary.utils.ActivityUtils;

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
        if (!isNetworkAvailable()) {
            Logger.e("网络不可用");
            onFail(new ApiException("网络不可用", ErrorType.NETWORK_ERROR));
            disposable.dispose();
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager) YcInit.getContext().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (null == manager)
            return false;
        NetworkInfo info = manager.getActiveNetworkInfo();
        return null != info && info.isAvailable();
    }

    @Override
    public void onNext(@NonNull T response) {
        if (YcInit.isIsDebug()) {//调试模式下不捕获异常
            onSuccess(response);
            return;
        }
        YcAppCompatActivity currentActivity = ActivityUtils.INSTANCE.getCurrentActivity();
        //防止闪退问题
        try {
            onSuccess(response);
        } catch (NullPointerException e) {
            e.printStackTrace();
            if (currentActivity != null)
                currentActivity.showToast("网络异常！错误码:" + ErrorType.DATE_NULL);
        } catch (ApiException e) {
            e.printStackTrace();
            if (currentActivity != null)
                currentActivity.showToast(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            if (currentActivity != null)
                currentActivity.showToast("网络异常！错误码:" + ErrorType.UN_KNOWN_ERROR);
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
