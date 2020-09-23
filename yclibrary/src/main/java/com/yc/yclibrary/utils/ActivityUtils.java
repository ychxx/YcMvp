package com.yc.yclibrary.utils;

import android.app.ActivityManager;
import android.content.Context;

import com.yc.yclibrary.base.YcAppCompatActivity;

import java.util.Stack;

/**
 * Activity管理工具类
 */

public enum ActivityUtils {
    INSTANCE();

    ActivityUtils() {
        mActivityStack = new Stack<>();
    }

    private Stack<YcAppCompatActivity> mActivityStack;

    /**
     * 添加一个Activity到堆栈中
     */
    public void addActivity(YcAppCompatActivity activity) {
        if (mActivityStack == null) {
            mActivityStack = new Stack<>();
        }
        mActivityStack.push(activity);
    }

    /**
     * 获取到当前显示Activity（堆栈中最后一个传入的activity）
     */
    public YcAppCompatActivity getCurrentActivity() {
        if (mActivityStack != null && !mActivityStack.isEmpty())
            return mActivityStack.lastElement();
        else
            return null;
    }

    /**
     * 从堆栈中移除指定的Activity
     */
    public void finishActivity(YcAppCompatActivity activity) {
        if (activity != null && !mActivityStack.isEmpty()) {
            mActivityStack.remove(activity);
            activity.finish();
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (YcAppCompatActivity activity : mActivityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
                break;
            }
        }
    }

    /**
     * 结束除当前传入以外所有Activity
     */
    public void finishOthersActivity(Class<?> cls) {
        if (mActivityStack != null)
            for (YcAppCompatActivity activity : mActivityStack) {
                if (!activity.getClass().equals(cls)) {
                    activity.finish();
                }
            }
    }

    /**
     * 结束除当前传入以外所有Activity
     */
    public void finishOthersActivity(YcAppCompatActivity activity) {
        if (mActivityStack != null)
            for (YcAppCompatActivity itemActivity : mActivityStack) {
                if (activity != itemActivity) {
                    itemActivity.finish();
                }
            }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        if (mActivityStack != null) {
            for (YcAppCompatActivity activity : mActivityStack) {
                activity.finish();
            }
            mActivityStack.clear();
        }
    }

    /**
     * 回退到activityClass页面（无则最后一个）
     */
    public void returnActivity(Class activityClass) {
        int activitySum = mActivityStack.size();
        for (int i = 1; i < activitySum; i++) {
            if (mActivityStack.get(activitySum - i).getClass().equals(activityClass)) {
                return;
            } else {
                finishActivity(mActivityStack.get(activitySum - i));
            }
        }
    }

    /**
     * 退出应用程序
     *
     * @param context
     */
    public void exitApp(Context context) {
        try {
            finishAllActivity();
            ActivityManager activityManager = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            activityManager.restartPackage(context.getPackageName());
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}