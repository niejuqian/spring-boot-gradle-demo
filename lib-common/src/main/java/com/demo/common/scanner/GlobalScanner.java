package com.demo.common.scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Modifier;

/**
 * Created by liuyang on 2017/9/1.
 */

@Component
public class GlobalScanner {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AssignableTypeFilter(Scannable.class));
        for (BeanDefinition beanDefinition : scanner.findCandidateComponents("com.jia.**")) {
            Class<? extends Scannable> c = (Class<? extends Scannable>) Class.forName(beanDefinition.getBeanClassName());
            if (Modifier.isAbstract(c.getModifiers())) {
                continue;
            }
            Scannable scannable = c.newInstance();
            scannable.scan();
        }
    }
}
