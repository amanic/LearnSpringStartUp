package com.xuxu.sprd.aop.testProxyFactoryBean;

/**
 * Created by martea on 2018/11/20.
 */
public class CPerson implements IPerson{


    private String name;

    public String queryName() {
        System.out.println("name:" + name);
        return name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
