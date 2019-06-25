package com.yc.easycode.mvp.model;

import com.yc.easycode.ApiServer;
import com.yc.easycode.bean.json.LoginJson;
import com.yc.yclibrary.mvp.IModel;
import com.yc.yclibrary.net.NetTransformer;
import com.yc.yclibrary.net.RetrofitUtils;

import java.io.File;
import java.util.List;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

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
//    public Observable<List<LoginJson>> uploadImg(String userName, File imgFile) {
//        RequestBody photoRequestBody = RequestBody.create(MediaType.parse("binary/octet-stream"), imgFile);
//        MultipartBody.Part part =  MultipartBody.Part.createFormData(paramName, file.getName(), photoRequestBody);//pic为key
//        return RetrofitUtils.Instance
//                .getApiService(ApiServer.class)
//                .login(userName, userPassword, "")
//                .compose(NetTransformer.compose());
//    }
}
