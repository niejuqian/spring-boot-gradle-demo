package com.demo.app.user.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by niejiuqian on 2018/3/26.
 */
@Component
public class UserInfoConfig {

    @Value("${userInfo.userName}")
    private String userName;

    @Value("${userInfo.userAge}")
    private String userAge;

    @Value("${userInfo.mobile}")
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
}
