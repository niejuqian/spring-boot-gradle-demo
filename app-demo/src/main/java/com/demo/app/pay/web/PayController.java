package com.demo.app.pay.web;

import com.demo.common.util.SpringContextUtil;
import com.demo.common.util.XmlHelpUtil;
import com.demo.pay.dto.PayRequest;
import com.demo.pay.dto.PayResponse;
import com.demo.pay.service.AbstractPayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 *  支付
 * @author niejiuqian
 * @date 2018/3/28
 */
@RestController
@RequestMapping("/pay")
public class PayController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping("/order/{channel}")
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


    /**
     * 微信支付回调
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/wxPayNotify")
    @ResponseBody
    public String wxPayNotify(HttpServletRequest request) throws Exception {
        String body = "";
        try {
            InputStream inStream = request.getInputStream();
            ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inStream.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }
            outSteam.close();
            inStream.close();
            body = new String(outSteam.toByteArray(), "utf-8");
        }catch (Exception e) {
            logger.error("=========>>>微信支付回调参数解析错误",e);
            return XmlHelpUtil.setXML("FAIL","解析参数错误");
        }
        logger.info("===========>>>>微信支付回调参数：{}",body);
        return XmlHelpUtil.setXML("SUCCESS","OK");
    }
}
