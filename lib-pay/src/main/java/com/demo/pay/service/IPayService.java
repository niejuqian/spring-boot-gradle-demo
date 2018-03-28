package com.demo.pay.service;

import com.demo.pay.dto.PayRequest;
import com.demo.pay.dto.PayResponse;

/**
 * Created by niejiuqian on 2018/3/28.
 */
public interface IPayService<T extends PayRequest,R extends PayResponse> {
    R doPay(T t);
}
