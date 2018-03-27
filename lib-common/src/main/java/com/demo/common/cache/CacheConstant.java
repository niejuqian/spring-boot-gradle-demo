package com.demo.common.cache;

/**
 * 缓存名称常量定义
 * Created by linyh on 2017/9/14.
 */
public interface CacheConstant {
    /**订单操作*/
    String ORDER_OPERATOR = "order_operator";

    // 登录用户tokenCache
    String TOKEN_SESSION_CACHE = "token_session_cache";

    // 发送短信cache
    String SMS_CODE_CACHE = "sms_code_cache";

    // 风险等级cache
    String RISK_LEVEL_CACHE = "risk_level_cache";

}
