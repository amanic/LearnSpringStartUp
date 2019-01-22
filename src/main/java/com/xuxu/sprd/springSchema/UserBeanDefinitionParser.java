package com.xuxu.sprd.springSchema;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * @auther chen.haitao
 * @date 2019-01-17
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {


    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }


    @Override
    protected void doParse(Element element, BeanDefinitionBuilder bean) {
        String id = element.getAttribute("id");
        String name = element.getAttribute("name");
        String sex = element.getAttribute("sex");
        int age = Integer.parseInt(element.getAttribute("age"));


        bean.addPropertyValue("id", id);
        bean.addPropertyValue("name", name);
        bean.addPropertyValue("sex", sex);
        bean.addPropertyValue("age", age);
    }
}