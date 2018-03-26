package com.demo.user.service;

import com.demo.user.entity.UserInfo;
import org.springframework.stereotype.Service;

/**
 * Created by niejiuqian on 2018/3/26.
 */
@Service
public class UserService {

    public UserInfo findUserInfo(){
        return new UserInfo().builder("王小二","18","15869584574");
    }
}
