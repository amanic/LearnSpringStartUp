package com.xuxu.sprd.pojo;

import org.springframework.stereotype.Service;

/**
 * Created by joakira on 2017/12/5.
 */
//@Service
public class Student {
    private String tClass;
    private Integer grade;

    public String gettClass() {
        return tClass;
    }

    public void settClass(String tClass) {
        this.tClass = tClass;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
