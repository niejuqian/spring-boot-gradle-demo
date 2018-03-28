package com.demo.user.entity;

/**
 * Created by niejiuqian on 2018/3/26.
 */
public class UserInfo {
    private String userName;
    private String userAge;
    private String mobile;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public UserInfo builder(String userName,String userAge,String mobile) {
        this.userAge = userAge;
        this.userName = userName;
        this.mobile = mobile;
        return this;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", userAge='" + userAge + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
