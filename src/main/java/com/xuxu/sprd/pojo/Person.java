package com.xuxu.sprd.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by joakira on 2017/12/4.
 */
//@Service
public class Person {
//    @Value("abc")
    private String name ="xx";
//    @Value("12")
    private Integer age=25;
//    @Resource
   /* private Student student;*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

   /* public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }*/

    public void printThrowException() {
        System.out.println("A great man should not live as a monster");
        throw new IllegalArgumentException();
    }

    public void playGame(){
        System.out.println(getName() + "正在玩游戏");
    }
}
