package com.xuxu.sprd.main;

/**
 * Created by martea on 2018/11/6.
 */
public class Main {
    public static void main(String[] args) {
//        ClassLoader loader = Thread.currentThread().getContextClassLoader();
//
//        System.out.println(loader);
//        System.out.println(loader.getParent());
//        System.out.println(loader.getParent().getParent());


        try {
            Class clazz = Thread.currentThread().getContextClassLoader().loadClass("com.xuxu.sprd.pojo.Person");
            System.out.println(clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
