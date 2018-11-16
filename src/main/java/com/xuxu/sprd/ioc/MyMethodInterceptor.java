package com.xuxu.sprd.ioc;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by martea on 2018/11/16.
 */
public class MyMethodInterceptor implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("目标方法前:" + method+"\n");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("目标方法后:" + method+"\n");
        return object;
    }
}
