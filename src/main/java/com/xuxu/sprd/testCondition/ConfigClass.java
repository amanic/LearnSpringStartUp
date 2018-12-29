package com.xuxu.sprd.testCondition;

import com.xuxu.sprd.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
public class ConfigClass {

    @Bean
    @Conditional(APersonCondition.class)
    public Person getAPerson(){
        Person person = new Person();
        person.setAge(1);
        person.setName("a");
        return person;
    }


    @Bean
    @Conditional(BPersonCondition.class)
    public Person getBPerson(){
        Person person = new Person();
        person.setAge(1);
        person.setName("b");
        return person;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        Person bean = context.getBean(Person.class);
        System.out.println(bean);
    }
}
