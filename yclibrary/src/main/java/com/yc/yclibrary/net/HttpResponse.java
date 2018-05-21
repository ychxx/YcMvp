package com.yc.yclibrary.net;


import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.hckj.steelbarinspection.exception.ErrorType;

/**
 * http响应参数实体类
 * 通过Gson解析属性名称需要与服务器返回字段对应,或者使用注解@SerializedName
 * 备注:这里与服务器约定返回格式
 */

public class HttpResponse<T> {
    /**
     * 描述信息
     */
    @SerializedName("msg")
    private String msg;
    /**
     * 状态码
     */
    @SerializedName("result")
    private int code;
    /**
     * 数据对象[成功返回对象,失败返回错误说明]
     */
    @SerializedName("data")
    private T data;

    /**
     * 是否成功(这里约定1)
     */
    public boolean isSuccess() {
        return code == ErrorType.SUCCESS ? true : false;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "[http response]" + "{\"code\": " + code + ",\"msg\":" + msg + ",\"data\":" + new Gson().toJson(data) + "}";
    }
}
