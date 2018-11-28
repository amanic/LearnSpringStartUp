package com.xuxu.sprd.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by martea on 2018/11/27.
 */
public class School implements /*ApplicationContextAware*/ BeanFactoryAware, BeanNameAware{

    private String beanId;

    private DefaultListableBeanFactory factory;

    private ClassPathXmlApplicationContext context;

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.factory = (DefaultListableBeanFactory) beanFactory;
        System.out.println("applicationContext contains beans like : "+Arrays.asList(BeanFactoryUtils.beanNamesForTypeIncludingAncestors(factory,Object.class)));
        System.out.println("beanFactory contains beanDefinitions like : "+ Arrays.asList(factory.getBeanDefinitionNames()));
        for (String s : factory.getBeanDefinitionNames()){
            factory.getBeanDefinition(s);
        }
    }
//
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.context = (ClassPathXmlApplicationContext)applicationContext;
//        System.out.println("getBeanDefinitionNames = "+Arrays.asList(context.getBeanDefinitionNames()));
//        System.out.println("applicationContext="+applicationContext);
//        System.out.println("applicationContext contains beans like : "+Arrays.asList(BeanFactoryUtils.beanNamesForTypeIncludingAncestors(((ClassPathXmlApplicationContext) applicationContext).getBeanFactory(),Object.class)));
//    }

    public void setBeanName(String name) {
        this.beanId = "beanName="+name;
    }

    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }

    public BeanFactory getFactory() {
        return factory;
    }

    public void setFactory(DefaultListableBeanFactory factory) {
        this.factory = factory;
    }

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ClassPathXmlApplicationContext context) {
        this.context = context;
    }
}
