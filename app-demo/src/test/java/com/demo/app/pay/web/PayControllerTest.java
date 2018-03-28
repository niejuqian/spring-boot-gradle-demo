package com.demo.app.pay.web;

import com.demo.app.AppDemoApplication;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;

/**
 * 支付单元调试
 * Created by niejiuqian on 2018/3/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppDemoApplication.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PayControllerTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private MockMvc mockMvc;
    @Autowired
    private PayController payController;
    @Before
    public void before(){
        mockMvc = MockMvcBuilders.standaloneSetup(payController)
                .build();
    }

    @Test
    public void wxPay(){
        try {
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.post("/pay/wxPay")
                            .characterEncoding(Charset.defaultCharset().name())
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
            )
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn();
            String result = mvcResult.getResponse().getContentAsString();
            logger.info("===============>>>返回结果：{}",result);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
