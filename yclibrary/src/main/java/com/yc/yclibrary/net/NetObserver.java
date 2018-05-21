package com.yc.yclibrary.net;


import com.hckj.steelbarinspection.exception.ApiException;
import com.hckj.steelbarinspection.exception.ErrorType;

/**
 *
 */

public abstract class NetObserver<T extends HttpResponse> extends BaseObserver<T> {

    @Override
    public void onNext(T response) {
        if (response.getCode() == ErrorType.FAIL) {
            onFail(new ApiException(response.getMsg(), ErrorType.FAIL));
        } else {
            super.onNext(response);
        }
    }
}
