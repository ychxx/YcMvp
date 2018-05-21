package com.yc.yclibrary.net;


import com.hckj.steelbarinspection.bean.json.CodeJson;
import com.hckj.steelbarinspection.bean.json.ComparisonJson;
import com.hckj.steelbarinspection.bean.json.LoginNewJson;
import com.hckj.steelbarinspection.bean.json.ProjectJson;
import com.hckj.steelbarinspection.bean.json.SamplingUploadInfo;
import com.hckj.steelbarinspection.bean.json.SearchSteelBarJson;
import com.hckj.steelbarinspection.bean.json.UpdateJson;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;


/**
 * 网络请求的接口都在这里
 */

public interface ApiService {

    //    @GET(UrlHelper.API_BASE + "checklogin")
//    Observable<List<LoginJson>> login(@Query("Name") String userName, @Query("Pwd") String passWord, @Query("Imei") String imei);
    @GET(UrlHelper.API_CHECK_IMG + "CheckLogin")
    Observable<HttpResponse<LoginNewJson>> login(@Query("userName") String userName, @Query("userPsw") String passWord);

    @GET(UrlHelper.API_CHECK_UPDATE + "update")
    Observable<List<UpdateJson>> checkUpdate(@Query("type") String packageName);


//    @Headers(UrlHelper.OTHER_BASE_URL + ":" + UrlHelper.URL_USER_TYPE)
//    @GET(UrlHelper.API_USER_TYPE + "GetMDJsonByUserAndSysId&SysId=23")
//    Observable<UserTypeJson> getUserType(@Query("userName") String userName, @Query("userPsw") String passWord);

    @GET(UrlHelper.API_BASE + "GetProjectList")
    Observable<List<ProjectJson>> getProjectList(@Query("q") String keyword);


    @FormUrlEncoded
    @POST(UrlHelper.API_CHECK_IMG + "CamPhotoMonitor")
    Observable<HttpResponse<Object>> checkImg(@Field("Img") String img);
//
//    @Multipart
//    @Headers(UrlHelper.OTHER_BASE_URL + ":" + UrlHelper.URL_UPLOAD_IMG)
//    @POST(UrlHelper.API_UPLOAD_IMG)
//    Observable<HttpResponse<Object>> uploadImg(@Part MultipartBody.Part img1, @Part MultipartBody.Part img2, @Part("light") RequestBody light, @Part("islamp") RequestBody isLamp, @Part("steelId") RequestBody steelId, @Part("Phone") RequestBody phoneInfo);


    @GET(UrlHelper.API_CHECK_IMG + "CreateCode_Simple")
    Observable<CodeJson> getCode();

    @Multipart
    @POST(UrlHelper.API_CHECK_IMG + "CreateTask")
    Observable<SamplingUploadInfo> uploadInfo(@Part("OnSiteTakePhoto") String OnSiteTakePhoto, @Part("data") String data, @Part("alpha") String alpha, @Part("TaskNum") String TaskNum, @Part("CamDate") String CamDate, @Part("EntrustmentItem") String EntrustmentItem, @Part("SamplesMan") String SamplesMan, @Part("SamplesName") String SamplesName, @Part("CamId") String CamId, @Part("Note") String Note, @Part("OnSiteSteelBarDiameter") String OnSiteSteelBarDiameter);


    @Multipart
    @POST(UrlHelper.API_CHECK_IMG + "SearchTask")
    Observable<SearchSteelBarJson> searchTask(@Part("TaskNum") String taskNum);

    @Multipart
    @POST(UrlHelper.API_CHECK_IMG + "LabComparePhoto")
    Observable<ComparisonJson> imgComparison(@Part("LabUserId") String userId, @Part("LabTakePhoto1") String takePhoto1, @Part("TaskNum") String taskNum, @Part("LabSteelBarDiameter") String steelBarDiameter);
}
