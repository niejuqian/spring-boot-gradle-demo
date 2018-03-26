package com.demo.app;

import com.demo.common.web.CommonApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 *  应用程序启动类
 * @author niejiuqian
 * @date 2018/3/26
 */
public class AppDemoApplication extends CommonApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder().sources(AppDemoApplication.class,WebConfig.class).run(args);
    }
}
