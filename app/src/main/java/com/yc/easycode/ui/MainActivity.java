package com.yc.easycode.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.yc.easycode.R;
import com.yc.easycode.mvp.MvpLoginActivity;
import com.yc.yclibrary.base.YcAppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

public class MainActivity extends YcAppCompatActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
    }

    @OnClick(R.id.mainBtn)
    public void onViewClicked() {
        MvpLoginActivity.newInstance(getActivity());
    }
}
