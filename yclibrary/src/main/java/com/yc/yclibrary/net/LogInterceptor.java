package com.yc.yclibrary.net;

import android.text.TextUtils;
import android.util.Log;

import com.orhanobut.logger.Logger;
import com.yc.yclibrary.EasyCode;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * 日志拦截器
 * 功能：
 * 1.打印网络请求和响应日志
 * 2.切换BaseUrl
 */
public class LogInterceptor implements Interceptor {
    private final Charset UTF8 = Charset.forName("UTF-8");

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        String realBaseUrl = getRealBaseUrl(request);
        if (!TextUtils.isEmpty(realBaseUrl)) {
            request = newRequest(request, realBaseUrl);
        }
        Logger.e("请求方式:" + request.method() + "\n网络请求:" + getFullRequest(request));
        Response response = chain.proceed(request);
        Logger.e("请求方式:" + request.method() + "\n网络请求:" + "返回数据:" + getFullResponse(response));
        return response;
    }

    /**
     * 获取表头里的baseUrl地址
     *
     * @param request
     * @return
     */
    private String getRealBaseUrl(Request request) {
        //获取request的创建者builder
        Request.Builder builder = request.newBuilder();
        //从request中获取headers，通过给定的键url_name
        List<String> headerValues = request.headers(EasyCode.OTHER_BASE_URL);
        if (headerValues != null && headerValues.size() > 0) {
            //将配置的header删除，因为header仅用作app和okhttp之间使用
            builder.removeHeader(EasyCode.OTHER_BASE_URL);
            return headerValues.get(0);
        } else {
            return null;
        }
    }

    /**
     * 在旧的基础上创建新的Request
     *
     * @param oldRequest 旧的Request
     * @param newBaseUrl 新的Request地址
     * @return
     */
    private Request newRequest(Request oldRequest, String newBaseUrl) {
        //获取旧的HttpUrl
        Request.Builder builder = oldRequest.newBuilder();
        HttpUrl oldHttpUrl = oldRequest.url();

        //根据newBaseUrl创建临时HttpUrl
        HttpUrl tempHttpUrl = HttpUrl.parse(newBaseUrl);
        if (tempHttpUrl == null) {
            Log.e("", "baseUrl替换失败：创建newHttpUrl为空");
            return oldRequest;
        }

        //通过tempHttpUrl修改旧的oldHttpUrl，生成新的HttpUrl
        HttpUrl newHttpUrl = oldHttpUrl
                .newBuilder()
                .scheme(tempHttpUrl.scheme())
                .host(tempHttpUrl.host())
                .port(tempHttpUrl.port())
                .build();
        //重建这个request
        return builder.url(newHttpUrl).build();
    }

    /**
     * 获取到完整的请求(地址+参数)
     *
     * @param request
     * @return
     */
    private String getFullRequest(Request request) throws IOException {
        RequestBody requestBody = request.body();
        if (requestBody != null) {
            String body;
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);

            Charset charset = null;
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }
            if (charset == null)
                charset = UTF8;
            body = buffer.readString(charset);
            return request.url() + "&" + body;
        } else {
            return request.url().toString();
        }

    }

    /**
     * 获取到完整的响应数据(服务器返回数据)
     *
     * @param response
     * @return
     */
    private String getFullResponse(Response response) throws IOException {
        ResponseBody responseBody = response.body();
        String reBody = null;
        if (response.body() != null) {
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();

            Charset charset = UTF8;
            MediaType contentType = responseBody.contentType();
            if (contentType != null) {
                try {
                    charset = contentType.charset(UTF8);
                } catch (UnsupportedCharsetException e) {
                    e.printStackTrace();
                }
            }
            reBody = buffer.clone().readString(charset);
        }
        return reBody;
    }
}
