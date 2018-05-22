package com.yc.yclibrary.exception;

import android.net.ParseException;

import com.google.gson.JsonParseException;
import com.google.gson.stream.MalformedJsonException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.HttpException;


/**
 * 异常处理类
 */

public class ExceptionEngine {

    public static ApiException handleException(Throwable e) {
        ApiException ex;
        if (e instanceof ApiException) {
            return (ApiException) e;
        } else if (e instanceof HttpException) {             //HTTP错误
            HttpException httpExc = (HttpException) e;
            ex = new ApiException(e, httpExc.code());
            ex.setMessage("网络错误,错误码 " + httpExc.code());  //均视为网络错误
            return ex;
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException || e instanceof MalformedJsonException) {  //解析数据错误
            ex = new ApiException(e, ErrorType.JSON_ERROR);
            ex.setMessage("解析错误");
            return ex;
        } else if (e instanceof ConnectException) {//连接网络错误
            ex = new ApiException(e, ErrorType.NETWORK_ERROR);
            ex.setMessage("连接失败");
            return ex;
        } else if (e instanceof SocketTimeoutException) {//网络超时
            ex = new ApiException(e, ErrorType.TIME_OUT_ERROR);
            ex.setMessage("网络超时");
            return ex;
        } else {  //未知错误
            ex = new ApiException(e, ErrorType.UN_KNOWN_ERROR);
            ex.setMessage("未知错误");
            return ex;
        }
    }
}

