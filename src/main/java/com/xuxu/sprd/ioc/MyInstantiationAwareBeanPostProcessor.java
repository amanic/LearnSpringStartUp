package com.xuxu.sprd.ioc;

import com.xuxu.sprd.pojo.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;

import java.beans.PropertyDescriptor;

/**
 * Created by martea on 2018/11/16.
 */
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

 /*   public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.print("beanName:"+beanName+"执行..postProcessBeforeInstantiation\n");
        //利用 其 生成动态代理
        if(beanClass==Person.class){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(beanClass);
            enhancer.setCallback(new MyMethodInterceptor());
            Person testFb = (Person)enhancer.create();
            System.out.print("返回动态代理\n");
            return testFb;
        }
        return null;
    }*/

    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.print("beanName:"+beanName+"执行..postProcessBeforeInstantiation\n");
        return null;
    }

    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.print("beanName:"+beanName+"执行..postProcessAfterInstantiation\n");

        return false;
    }

    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        System.out.print("beanName:"+beanName+"执行..postProcessPropertyValues\n");
        if(bean instanceof Person){
            PropertyValue value = pvs.getPropertyValue("name");
            System.out.print("修改之前 name 的value是："+value.getValue()+"\n");
            value.setConvertedValue("我修改啦");
            return pvs;
        }
        return pvs;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.print("beanName:"+beanName+"执行..postProcessBeforeInitialization\n");

        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.print("beanName:"+beanName+"执行..postProcessAfterInitialization\n");

        return bean;
    }
}
