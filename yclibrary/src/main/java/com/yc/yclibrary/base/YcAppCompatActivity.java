package com.yc.yclibrary.base;

import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.widget.Toast;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yc.yclibrary.utils.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 *
 */

public abstract class YcAppCompatActivity extends RxAppCompatActivity {
    private Unbinder unbinder;

    /**
     * 获取布局id
     */
    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * 初始化视图
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 初始化数据
     */
    protected void initData() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUtils.INSTANCE.addActivity(this);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        initView(savedInstanceState);
        initData();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        ActivityUtils.INSTANCE.finishActivity(this);
    }

    public YcAppCompatActivity getActivity() {
        return this;
    }

    /**
     * 显示吐司()
     *
     * @param msg 内容
     */
    public void showToast(String msg) {
        try {
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Looper.prepare();
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
            Looper.loop();
        }
    }

    public void showToast(@StringRes int resId) {
        try {
            Toast.makeText(getActivity(), getString(resId), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Looper.prepare();
            Toast.makeText(getActivity(), getString(resId), Toast.LENGTH_SHORT).show();
            Looper.loop();
        }
    }
}