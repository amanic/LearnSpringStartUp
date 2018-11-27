package com.xuxu.sprd.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by martea on 2018/11/27.
 */
public class School implements ApplicationContextAware, BeanFactoryAware{

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("beanFactory"+beanFactory);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContext="+applicationContext);
    }
}
