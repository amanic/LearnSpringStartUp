package com.xuxu.sprd.ioc;

import com.xuxu.sprd.aop.testProxyFactoryBean.CPerson;
import com.xuxu.sprd.pojo.Person;
import com.xuxu.sprd.pojo.School;
import com.xuxu.sprd.springSchema.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by joakira on 2017/12/4.
 */
public class RefreshDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
//        //默认第一次getBean的时候发生依赖注入
////        CPerson person = (CPerson)context.getBean("cperson");
//        Person person = (Person)context.getBean("person");
////        Person person = context.getBean(Person.class);
////        person.getName();
////        System.out.println(person.queryName());
//        person.playGame();
////        School school = (School)context.getBean("school");
////        System.out.println(school.getBeanId());
////        System.out.println(school.toString());

        User user = (User) context.getBean("eric");
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getSex());
        System.out.println(user.getAge());


    }
}


