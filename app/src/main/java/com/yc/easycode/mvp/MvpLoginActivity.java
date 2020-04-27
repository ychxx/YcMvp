package com.yc.easycode.mvp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yc.easycode.ApiServer;
import com.yc.easycode.R;
import com.yc.easycode.bean.json.LoginJson;
import com.yc.easycode.mvp.contact.MvpLoginC;
import com.yc.easycode.mvp.presenter.MvpLoginP;
import com.yc.yclibrary.base.YcMvpAppCompatActivity;
import com.yc.yclibrary.exception.ApiException;
import com.yc.yclibrary.net.BaseObserver;
import com.yc.yclibrary.net.NetTransformer;
import com.yc.yclibrary.net.RetrofitUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Header;

/**
 * mvp登录页面
 */

public class MvpLoginActivity extends YcMvpAppCompatActivity<MvpLoginP> implements MvpLoginC.V {
    @BindView(R.id.tvLoginResult)
    TextView tvLoginResult;

    public static void newInstance(Activity activity) {
        activity.startActivity(new Intent(activity, MvpLoginActivity.class));
    }

    @Override
    protected MvpLoginP loadPresenter() {
        return new MvpLoginP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    public void onLoginSuccess(LoginJson json) {
        tvLoginResult.setText("结果：" + json.toString());
    }

    @Override
    public void onLoginFail(ApiException apiException) {
        tvLoginResult.setText("结果：" + apiException.getMessage());

    }

    private void uploadImg() {
//        Bitmap bitmap = getResources().getDrawable(R.drawable.test_img);
        Map<String, String> map = new HashMap<>();
        map.put("userId", "2050");
        Gson gson = new Gson();
        String params = gson.toJson(map);
        Resources r = this.getActivity().getResources();
        InputStream inputStream = r.openRawResource(R.drawable.test_img);
        RequestBody photoRequestBody = null;
        try {
            photoRequestBody = RequestBody.create(MediaType.parse("binary/octet-stream"), toByte(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
        MultipartBody.Part part = MultipartBody.Part.create(photoRequestBody);//pic为key
        RetrofitUtils.Instance
                .getApiService(ApiServer.class)
                .uploadImg( part)
                .compose(NetTransformer.compose())
                .compose(bindLifecycle())
                .doOnSubscribe((disposable) -> showLoading("加载中..."))
                .doFinally(() -> hideLoading())
                .subscribe(new BaseObserver<Object>() {
                    @Override
                    public void onSuccess(Object json) {
//                        getIView().onLoginSuccess(json.get(0));
                    }

                    @Override
                    public void onFail(ApiException msg) {
//                        getIView().onLoginFail(msg);
                    }
                });
    }

    private byte[] toByte(InputStream inputstream) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = 1024;
        byte tmp[] = new byte[len];
        int i;

        while ((i = inputstream.read(tmp, 0, len)) > 0) {
            baos.write(tmp, 0, i);
        }
        byte imgs[] = baos.toByteArray();
        if (inputstream != null) {
            inputstream.close();
        }
        return imgs;
    }

    @OnClick({R.id.btnLoginFail, R.id.btnLoginSuccess})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLoginFail:
                mPresenter.login("", "");
//                uploadImg();
                break;
            case R.id.btnLoginSuccess:
                mPresenter.login("admin", "hckj1234");
//                mPresenter.test();
                break;
        }
    }
}
