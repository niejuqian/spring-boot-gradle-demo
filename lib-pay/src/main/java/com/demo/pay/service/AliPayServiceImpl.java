package com.demo.pay.service;

import com.demo.pay.dto.AliPayRequest;
import com.demo.pay.dto.AliPayResponse;
import org.springframework.stereotype.Service;

/**
 * Created by niejiuqian on 2018/3/28.
 */
@Service("aliPayServiceImpl")
public class AliPayServiceImpl extends AbstractPayService<AliPayRequest,AliPayResponse> {
    @Override
    public AliPayResponse doPay(AliPayRequest aliPayRequest) {
        logger.info("===============>>>>开始执行支付宝支付");
        return null;
    }
}
