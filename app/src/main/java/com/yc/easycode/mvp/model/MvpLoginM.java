package com.yc.easycode.mvp.model;

import com.yc.easycode.ApiServer;
import com.yc.easycode.bean.json.LoginJson;
import com.yc.yclibrary.mvp.IModel;
import com.yc.yclibrary.net.NetTransformer;
import com.yc.yclibrary.net.RetrofitUtils;

import java.util.List;

import io.reactivex.Observable;

/**
 *
 */

public class MvpLoginM implements IModel{
    public Observable<List<LoginJson>> login(String userName, String userPassword) {
        return RetrofitUtils.Instance
                .getApiService(ApiServer.class)
                .login(userName, userPassword, "")
                .compose(NetTransformer.compose());
    }
}
