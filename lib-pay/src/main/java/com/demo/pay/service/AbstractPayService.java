package com.demo.pay.service;

import com.demo.pay.dto.PayRequest;
import com.demo.pay.dto.PayResponse;
import com.demo.user.entity.UserInfo;
import com.demo.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 支付抽象类
 *
 * @author niejiuqian
 * @date 2018/3/28
 */
public abstract class AbstractPayService<T extends PayRequest,R extends PayResponse> implements IPayService<T,R>{
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    /**
     * 支付前操作
     */
    protected void payBefore(){
        logger.info("===========>>>开始进行支付前操作");
        UserInfo userInfo = userService.findUserInfo();
        logger.info("===========>>>用户信息：{}",userInfo);
    }

    public R executePay(T t){
        payBefore();
        R r = doPay(t);
        payAfter();
        return r;
    }

    /**
     * 支付后操作
     */
    protected void payAfter(){
        logger.info("===========>>>开始执行支付成功后操作");
    }
}
