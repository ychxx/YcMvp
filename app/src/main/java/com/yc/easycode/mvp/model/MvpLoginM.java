package com.yc.easycode.mvp.model;

import com.yc.easycode.ApiServer;
import com.yc.yclibrary.EasyCode;
import com.yc.yclibrary.mvp.IModel;
import com.yc.yclibrary.net.NetTransformer;
import com.yc.yclibrary.net.RetrofitUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 *
 */

public class MvpLoginM implements IModel{
    public Observable login(String userName, String userPassword) {
        return RetrofitUtils.Instance
                .getApiService(ApiServer.class)
                .login(userName, userPassword, "")
                .compose(NetTransformer.compose());
    }
}
