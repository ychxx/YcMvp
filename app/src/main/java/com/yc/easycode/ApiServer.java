package com.yc.easycode;



import com.yc.easycode.bean.json.LoginJson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
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

//    @Headers(UrlHelper.OTHER_BASE_URL + ":" + UrlHelper.URL_USER_TYPE)
//    @GET(UrlHelper.API_USER_TYPE + "GetMDJsonByUserAndSysId&SysId=23")
//    Observable<UserTypeJson> getUserType(@Query("userName") String userName, @Query("userPsw") String passWord);

//
//    @Multipart
//    @Headers(UrlHelper.OTHER_BASE_URL + ":" + UrlHelper.URL_UPLOAD_IMG)
//    @POST(UrlHelper.API_UPLOAD_IMG)
//    Observable<HttpResponse<Object>> uploadImg(@Part MultipartBody.Part img1, @Part MultipartBody.Part img2, @Part("light") RequestBody light, @Part("islamp") RequestBody isLamp, @Part("steelId") RequestBody steelId, @Part("Phone") RequestBody phoneInfo);

}
