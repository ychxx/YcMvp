package com.yc.yclibrary.bean;

import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;

/**
 *
 */
public class InterceptorBean {
    private String url;
    private RequestBody body;
    private boolean isChangeUrl = false;
    private boolean isChangeBody = false;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        if (!TextUtils.isEmpty(url)) {
            this.url = url;
            this.isChangeUrl = true;
        }
    }

    public RequestBody getBody() {
        return body;
    }

    public String bodyToString() {
        if (body == null) {
            return "";
        }
        Buffer buffer = new Buffer();
        try {
            body.writeTo(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("InterceptorBean", "拦截器出错啦！！！！！！");
            return "";
        }
        Charset charset = null;
        MediaType contentType = body.contentType();
        if (contentType != null) {
            charset = contentType.charset(StandardCharsets.UTF_8);
        }
        if (charset == null)
            charset = StandardCharsets.UTF_8;
        return buffer.readString(charset);
    }

    public void setBody(RequestBody body) {
        if (body != null) {
            this.body = body;
            this.isChangeBody = true;
        }

    }

    public boolean isChangeUrl() {
        return isChangeUrl;
    }

    public void setChangeUrl(boolean changeUrl) {
        isChangeUrl = changeUrl;
    }

    public boolean isChangeBody() {
        return isChangeBody;
    }

    public void setChangeBody(boolean changeBody) {
        isChangeBody = changeBody;
    }
}
