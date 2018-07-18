package com.shxseer.watch.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取spring容器的对象
 *
 * @author yangsonglin
 * @create 2018-07-12 10:49
 **/
@Component
public class SpringContextBeanUtils implements ApplicationContextAware {
    protected static ApplicationContext context;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
       context = applicationContext;
    }

    public static ApplicationContext getContext() {
       return context;
    }

    public static Object getBean(String name){
        return context.getBean(name);
    }

}


