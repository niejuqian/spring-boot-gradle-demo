package com.demo.pay.service;

import com.demo.pay.dto.WXPayRequest;
import com.demo.pay.dto.WXPayResponse;
import org.springframework.stereotype.Service;

/**
 * Created by niejiuqian on 2018/3/28.
 */
@Service("wxPayServiceImpl")
public class WXPayServiceImpl extends AbstractPayService<WXPayRequest,WXPayResponse> {
    @Override
    public WXPayResponse doPay(WXPayRequest wxPayRequest) {
        logger.info("===================>>>开始执行微信支付");
        return null;
    }
}
