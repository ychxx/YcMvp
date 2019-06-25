package com.yc.easycode;


import com.yc.easycode.bean.json.LoginJson;
import com.yc.yclibrary.YcInit;
import com.yc.yclibrary.net.BaseObserver;

import org.xutils.http.annotation.HttpResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

/**
 *
 */

public interface ApiServer {
    @GET(UrlHelper.BASE_API + "checklogin")
    Observable<List<LoginJson>> login(@Query("Name") String userName, @Query("Pwd") String passWord, @Query("Imei") String imei);

    @GET(UrlHelper.BASE_API + "update")
    Observable<List<LoginJson>> checkUpdate(@Query("type") String packageName);

    //
    @Multipart
    @Headers({YcInit.OTHER_BASE_URL + ":" + "http://10.1.3.189:8080/",
            "Cookie:JSESSIONID=C993CF92B77985B64F2760A3FD34DEA9",
            "Accept-Language:zh-CN, en-US",
            "Cache-Control:no-cache",
            "authCode:4QrcOUm6",
            "AttachStream-Data:{\"userId\":\"2050\"}"
    })
    @POST("app/android/UploadUserImage.invoke")
    Observable<BaseObserver<Object>> uploadImg( @Part MultipartBody.Part img2);

    @Multipart
    @Headers({YcInit.OTHER_BASE_URL + ":" + "http://10.1.3.189:8080/",
            "Cookie:JSESSIONID=9FB4AB729F0926FB65247EC7E8901EB1",
            "Accept-Language:zh-CN, en-US",
            "Cache-Control: no-cache"
    })
    @POST("app/android/UploadUserImage.invoke")
    Observable<BaseObserver<Object>> uploadImg(@Header("AttachStream-Data") String header, @Part RequestBody img2);

//    @Headers(UrlHelper.OTHER_BASE_URL + ":" + UrlHelper.URL_USER_TYPE)
//    @GET(UrlHelper.API_USER_TYPE + "GetMDJsonByUserAndSysId&SysId=23")
//    Observable<UserTypeJson> getUserType(@Query("userName") String userName, @Query("userPsw") String passWord);

//
//    @Multipart
//    @Headers(UrlHelper.OTHER_BASE_URL + ":" + UrlHelper.URL_UPLOAD_IMG)
//    @POST(UrlHelper.API_UPLOAD_IMG)
//    Observable<HttpResponse<Object>> uploadImg(@Part MultipartBody.Part img1, @Part MultipartBody.Part img2, @Part("light") RequestBody light, @Part("islamp") RequestBody isLamp, @Part("steelId") RequestBody steelId, @Part("Phone") RequestBody phoneInfo);

}
