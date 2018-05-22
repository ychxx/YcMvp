package com.yc.easycode.bean.json;

/**
 *
 */

public class LoginJson {


    /**
     * UserAccount : admin
     * UserName : 管理员
     * UserId : 100039
     */

    private String UserAccount;
    private String UserName;
    private String UserId;

    public String getUserAccount() {
        return UserAccount;
    }

    public void setUserAccount(String UserAccount) {
        this.UserAccount = UserAccount;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    @Override
    public String toString() {
        return "LoginJson{" +
                "UserAccount='" + UserAccount + '\'' +
                ", UserName='" + UserName + '\'' +
                ", UserId='" + UserId + '\'' +
                '}';
    }
}

