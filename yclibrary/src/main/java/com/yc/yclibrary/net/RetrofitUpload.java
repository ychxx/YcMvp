package com.yc.yclibrary.net;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * 上传图片转换
 */
public class RetrofitUpload {
    public static final String MEDIA_TYPE_TEXT = "text/plain; charset=utf-8";
    public static final String MEDIA_TYPE_File = "multipart/form-data";

    /**
     * 根据图片路径转成MultipartBody
     *
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
     *
     * @param paramName 入参名
     * @return
     */
    public static RequestBody toRequestBody(String paramName, String mediaType) {
        return RequestBody.create(MediaType.parse(mediaType), paramName);
    }

    public static RequestBody toRequestBody(File paramName, String mediaType) {
        return RequestBody.create(MediaType.parse(mediaType), paramName);
    }

    /**
     * 上传多文件
     * @param file1
     * @param key1
     * @param file2
     * @param key2
     * @return
     */
    public static Map<String, RequestBody> getRequests(File file1, String key1, File file2, String key2) {
        Map<String, RequestBody> map = new HashMap<>();
        map.put(key1 + "\"; filename=\"" + file1.getName(), toRequestBody(file1, MEDIA_TYPE_File));
        map.put(key2 + "\"; filename=\"" + file2.getName(), toRequestBody(file2, MEDIA_TYPE_File));
        return map;
    }

    public static Map<String, RequestBody> getRequests(File file1, String key1, File file2, String key2, File file3, String key3) {
        Map<String, RequestBody> map = new HashMap<>();
        map.put(key1 + "\"; filename=\"" + file1.getName(), toRequestBody(file1, MEDIA_TYPE_File));
        map.put(key2 + "\"; filename=\"" + file2.getName(), toRequestBody(file2, MEDIA_TYPE_File));
        map.put(key3 + "\"; filename=\"" + file3.getName(), toRequestBody(file3, MEDIA_TYPE_File));
        return map;
    }

}
