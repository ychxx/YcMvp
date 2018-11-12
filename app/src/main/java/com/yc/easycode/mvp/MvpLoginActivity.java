package com.yc.easycode.mvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yc.easycode.R;
import com.yc.easycode.bean.json.LoginJson;
import com.yc.easycode.mvp.contact.MvpLoginC;
import com.yc.easycode.mvp.presenter.MvpLoginP;
import com.yc.yclibrary.base.YcMvpAppCompatActivity;
import com.yc.yclibrary.exception.ApiException;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * mvp登录页面
 */

public class MvpLoginActivity extends YcMvpAppCompatActivity<MvpLoginP> implements MvpLoginC.V {
    @BindView(R.id.tvLoginResult)
    TextView tvLoginResult;
    public static void newInstance(Activity activity){
        activity.startActivity(new Intent(activity,MvpLoginActivity.class));
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

    @OnClick({R.id.btnLoginFail, R.id.btnLoginSuccess})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLoginFail:
                mPresenter.login("", "");
                break;
            case R.id.btnLoginSuccess:
                mPresenter.login("admin", "hckj1234");
                break;
        }
    }
}
