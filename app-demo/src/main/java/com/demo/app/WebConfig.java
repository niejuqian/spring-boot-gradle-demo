package com.demo.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *  配置
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
public class WebConfig extends WebMvcConfigurerAdapter {

}
