package com.xuxu.sprd.aop.testProxyFactoryBean;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by martea on 2018/11/20.
 */
public class PersonAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before......");
    }

    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("afterReturning......");
    }

}