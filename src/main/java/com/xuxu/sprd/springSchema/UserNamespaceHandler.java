package com.xuxu.sprd.springSchema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @auther chen.haitao
 * @date 2019-01-17
 */

public class UserNamespaceHandler extends NamespaceHandlerSupport {


    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}