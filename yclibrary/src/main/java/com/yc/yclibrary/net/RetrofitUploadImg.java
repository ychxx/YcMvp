package com.yc.yclibrary.net;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 *  上传图片转换
 */
public class RetrofitUploadImg {
    /**
     * 根据图片路径转成MultipartBody
     * @param imgPath   路径
     * @param paramName 入参名
     * @return
     */
    public static MultipartBody.Part toPart(String imgPath, String paramName) {
        File file = new File(imgPath);
        RequestBody photoRequestBody = RequestBody.create(MediaType.parse("image/*"), file);
        return MultipartBody.Part.createFormData(paramName, file.getName(), photoRequestBody);//pic为key
    }

    /**
     * 上传图片时伴随的其他入参
     * @param paramName 入参名
     * @return
     */
    public static RequestBody toRequestBody(String paramName) {
        return  RequestBody.create(MediaType.parse("text/plain; charset=utf-8"), paramName);
    }

}
