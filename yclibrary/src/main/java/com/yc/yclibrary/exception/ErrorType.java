package com.yc.yclibrary.exception;

/**
 * 错误类型
 */

public interface ErrorType {
    /**
     * 未知错误
     */
    int UN_KNOWN_ERROR = 1000;
    /**
     * 网络错误
     */
    int NETWORK_ERROR = 1002;
    /**
     * 网络超时
     */
    int TIME_OUT_ERROR = 1003;
    /**
     * 解析错误
     */
    int JSON_ERROR = 1004;
    /**
     * 数据为空
     */
    int DATE_NULL = 1005;
}
