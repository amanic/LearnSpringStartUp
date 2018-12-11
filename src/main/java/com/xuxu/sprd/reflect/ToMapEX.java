package com.xuxu.sprd.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by martea on 2018/12/11.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ToMapEX {

    /**
     *存放到map的key
     * @return
     */
    String value() default "";

    /**
     * 是否需要转化为map元素
     * @return
     */
    boolean required() default true;

    /**
     * 当该属性的值为'notConvertWhen'发的当前值的时候，则不存放到map
     * @return
     */
    String notConvertWhen() default "";

    /**
     * 是否为**开始时间
     * @return
     */
    boolean isStart() default false;

    /**
     * 是否为**结束时间
     * @return
     */
    boolean isEnd() default false;

    /**
     * 传入的时间格式，默认为yyyy-MM-dd，如果不是，请标注出来例如：@ToMapEX(dataStyle="yyyy-MM-dd HH:mm:ss")
     * @return
     */
    String dateStyle() default "yyyy-MM-dd";
}
