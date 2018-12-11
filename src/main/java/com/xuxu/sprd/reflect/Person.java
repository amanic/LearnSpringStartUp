package com.xuxu.sprd.reflect;

/**
 * Created by martea on 2018/12/11.
 */
public class Person {

    @ToMapEX(value = "年龄",notConvertWhen = "-1")
    private Integer age;

    @ToMapEX(notConvertWhen = "")
    private String name;

    @ToMapEX(required = false)
    private String remark;

    @ToMapEX(isStart = true, dateStyle = "yyyy-MM-dd HH:mm:ss")
    private String startBirthDay;

    @ToMapEX(isEnd = true)
    private String endBirthDay;

    private School school;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStartBirthDay() {
        return startBirthDay;
    }

    public void setStartBirthDay(String startBirthDay) {
        this.startBirthDay = startBirthDay;
    }

    public String getEndBirthDay() {
        return endBirthDay;
    }

    public void setEndBirthDay(String endBirthDay) {
        this.endBirthDay = endBirthDay;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
