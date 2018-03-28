package com.demo.app;

import com.demo.common.web.CommonApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 *  应用程序启动类
 * @author niejiuqian
 * @date 2018/3/26
 */
@SpringBootApplication
@EnableConfigurationProperties
@EnableJpaRepositories("com.demo.**.jpa")
@ComponentScan(basePackages = "com.demo")
/*@EnableMongoRepositories("com.jia.**.mongo")
@EnableElasticsearchRepositories("com.jia.**.search")*/
@EntityScan("com.demo.**.entity")
@EnableAsync
public class AppDemoApplication extends CommonApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder().sources(AppDemoApplication.class,WebConfig.class).run(args);
    }
}
