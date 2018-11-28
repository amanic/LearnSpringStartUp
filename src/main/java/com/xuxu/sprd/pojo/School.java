package com.xuxu.sprd.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by martea on 2018/11/27.
 */
public class School implements ApplicationContextAware, BeanFactoryAware, BeanNameAware{

    private String beanId;

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("beanFactory"+beanFactory);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContext="+applicationContext);
    }

    public void setBeanName(String name) {
        this.beanId = "beanName="+name;
    }

    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }
}
