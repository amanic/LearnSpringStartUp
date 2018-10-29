package com.xuxu.sprd.test;

import com.xuxu.sprd.anno.TestAnno;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by joakira on 2018/1/9.
 */
public class AnnoTest {

    public static void main(String[] args) {
        Annotation[] annotations = Sjy.class.getAnnotations();
        Class<? extends Annotation> aClass = annotations[0].annotationType();
        Field[] fields = aClass.getFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                Class<?> type = fields[i].getType();
                String val = (String) fields[i].get("name");
                System.out.println(val);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}

@TestAnno
class Sjy{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

