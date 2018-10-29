package com.xuxu.sprd.ioc;

import com.xuxu.sprd.pojo.Person;
import com.xuxu.sprd.pojo.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by joakira on 2017/12/13.
 */
public class AnnotationRefreshDemo {

    public static void main(String[] args) {
        //手动指定class,AnnotationConfigApplicationContext可以使用参数是class是构造方法
        Class[] annos=new Class[]{Person.class,Student.class};
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(annos);

        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.xuxu.sprd.pojo");
        Person person = (Person) context.getBean("person");
        System.out.println(person.getName()+" : "+person.getAge());
    }
}
