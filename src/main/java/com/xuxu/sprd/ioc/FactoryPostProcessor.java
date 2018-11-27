package com.xuxu.sprd.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 实现{@link BeanFactoryPostProcessor}接口，操作beandefinition
 * Created by martea on 2018/11/27.
 */
public class FactoryPostProcessor implements BeanFactoryPostProcessor{

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("************************BeanFactoryPostProcessor************************");
        String[] beanStr = beanFactory.getBeanDefinitionNames();
        for (String s : beanStr){
            if(s.equals("person")){
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(s);
                MutablePropertyValues m = beanDefinition.getPropertyValues();
                if (m.contains("name")) {
                    m.addPropertyValue("name", "赵四");
                    System.out.println("》》》修改了name属性初始值了");
                }
            }
        }
    }

}
