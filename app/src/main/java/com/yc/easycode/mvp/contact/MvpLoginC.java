package com.yc.easycode.mvp.contact;

import com.yc.easycode.bean.json.LoginJson;
import com.yc.yclibrary.exception.ApiException;
import com.yc.yclibrary.mvp.IView;

/**
 *
 */

public class MvpLoginC {


    public interface V extends IView {
        /**
         * 登录成功
         */
        void onLoginSuccess(LoginJson json);

        /**
         * 登录失败
         */
        void onLoginFail(ApiException apiException);
    }

    public interface P {
        void login(String userName, String userPassword);
    }
}
