package com.xuxu.sprd.aop;

import org.aspectj.lang.annotation.*;

/**
 * Created by joakira on 2017/12/6.
 */
@Aspect
public class StudentAdvice {

    @Pointcut("execution(* com.xuxu.sprd.pojo.Person.get*(..))")  //定义切点
    public void getMethod(){} //切点方法，方法名称相当于ID，方法名称随便取

    @Pointcut("execution(* com.xuxu.sprd.pojo.Person.play*(..))")
    public void doplay(){}

    /**
     * This is the method which I would like to execute
     * before a selected method execution.
     */
    @Before("doplay()")   //切点方法执行之前执行@Before
    public void beforeAdvice() {
        System.out.println("you must learn first.");
    }

    /**
     * This is the method which I would like to execute
     * after a selected method execution.
     */
    @After("getMethod()")   //切点方法执行之后执行@After
    public void afterAdvice() {
        System.out.println("我已经获取了你的某些属性");
    }

    /**
     * This is the method which I would like to execute
     * when any method returns.
     */
    @AfterReturning(pointcut = "getMethod()",returning = "retVal")//切点方法返回值完成后执行@AfterReturning
    public void afterReturningAdvice(Object retVal) {
        System.out.println("Returning:" + retVal.toString());
    }

    /**
     * This is the method which I would like to execute
     * if there is an exception raised.
     */
    @AfterThrowing(pointcut = "getMethod()",throwing = "ex")//切点方法抛出异常之后执行@AfterThrowing
    public void AfterThrowingAdvice(IllegalArgumentException ex) {
        System.out.println("There has been an exception: " + ex.toString());
    }
}
