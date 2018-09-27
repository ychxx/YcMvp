package com.yc.yclibrary.bean;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 */
@IntDef({BindEvent.ATTACH, BindEvent.CREATE, BindEvent.CREATE_VIEW, BindEvent.START, BindEvent.RESUME, BindEvent.PAUSE, BindEvent.STOP, BindEvent.DESTROY_VIEW, BindEvent.DESTROY, BindEvent.DETACH})
@Retention(RetentionPolicy.SOURCE)
public @interface BindEvent {
    int ATTACH = 1;
    int CREATE = 2;
    int CREATE_VIEW = 3;
    int START = 4;
    int RESUME = 5;
    int PAUSE = 6;
    int STOP = 7;
    int DESTROY_VIEW = 8;
    int DESTROY = 9;
    int DETACH = 10;
}
