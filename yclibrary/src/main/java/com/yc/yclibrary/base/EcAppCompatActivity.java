package com.yc.yclibrary.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.widget.Toast;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yc.yclibrary.utils.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 *
 */

public abstract class EcAppCompatActivity extends RxAppCompatActivity {
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
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        initView(savedInstanceState);
        initData();
        ActivityUtils.INSTANCE.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        ActivityUtils.INSTANCE.finishActivity(this);
    }

    public EcAppCompatActivity getActivity() {
        return this;
    }

    /**
     * 显示吐司()
     *
     * @param msg 内容
     */
    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}