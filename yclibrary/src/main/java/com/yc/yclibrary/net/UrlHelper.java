package com.yc.yclibrary.net;

import java.util.HashMap;

/**
 *
 * 添加所有的接口
 */

public class UrlHelper {
    public static String BASE_URL = "http://api.jsqqy.com/";//正式地址
//    public static String BASE_URL = "http://10.1.3.86:8023/";//测试地址
    public static final String OTHER_BASE_URL = "other_base_url";//用于切换url的标示

    //测试登录
    public static final String URL_TEST = "url_test";
    public static final String API = "Services/";


    //钢筋识别的Api
    public static final String API_BASE = "api.ashx?action=";

    //检测版本的Api
    public static final String API_CHECK_UPDATE = "/api.ashx?action=";

    //检测用户类别的url
    public static final String URL_USER_TYPE = "URL_USER_TYPE";
    //检测用户类别的Api
    public static final String API_USER_TYPE = "Handler/MobileAppsHandler.ashx?interfaceName=";

    //检测图片模糊地址
    public static final String URL_CHECK_IMG = "url_check_img";
    public static final String API_CHECK_IMG = "ApiSamplesTask.ashx?action=";

    //朱强上传采集图片样本地址
    public static final String URL_UPLOAD_IMG = "url_upload_img";
    public static final String API_UPLOAD_IMG = "BatchUpload.ashx?";

    public static final HashMap<String, String> baseUrls = new HashMap<String, String>() {
        {
            put(URL_TEST, "http://192.168.1.186:4545/");
            put(URL_CHECK_IMG, "http://10.1.3.86:8023/");
            put(URL_UPLOAD_IMG, "http://10.1.3.68:26876/");
            put(URL_USER_TYPE, "http://ad.jsqqy.com/");

        }
    };
}
