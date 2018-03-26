package com.demo.app.user.web;

import com.demo.app.user.dto.UserInfoConfig;
import com.demo.user.entity.UserInfo;
import com.demo.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author niejiuqian
 * @date 2018/3/26
 */
@Controller
public class UserInfoController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoConfig userInfoConfig;

    @RequestMapping("/user/info")
    public @ResponseBody UserInfo findUserInfo(){
        logger.info("==================>>>获取用户信息");
        return userService.findUserInfo();
    }

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("userName",userInfoConfig.getUserName());
        model.addAttribute("userAge",userInfoConfig.getUserAge());
        model.addAttribute("mobile",userInfoConfig.getMobile());
        return "page/index";
    }
}
