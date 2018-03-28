package com.demo.app.pay.web;

import com.demo.common.util.SpringContextUtil;
import com.demo.pay.dto.PayRequest;
import com.demo.pay.dto.PayResponse;
import com.demo.pay.service.AbstractPayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by niejiuqian on 2018/3/28.
 */
@RestController
@RequestMapping("/pay")
public class PayController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping("/{channel}")
    public PayResponse pay(@PathVariable("channel") String channel){
        AbstractPayService payService = (AbstractPayService) SpringContextUtil.getBean(channel + "ServiceImpl");
        PayResponse payResponse = null;
        if (null == payService) {
            logger.info("============>>无效的支付方式");
        } else {
            PayRequest payRequest = null;
            payResponse = payService.executePay(payRequest);
        }
        return payResponse;
    }
}
