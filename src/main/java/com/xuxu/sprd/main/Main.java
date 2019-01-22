package com.xuxu.sprd.main;

import java.io.File;

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

//        try {
//            Class clazz = Thread.currentThread().getContextClassLoader().loadClass("com.xuxu.sprd.pojo.Person");
//            System.out.println(clazz);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Father<Son> son =  new Father<Son>();
        son.setT((Son)son);
//        son.setS("123");
        System.out.println(son.tToString());
    }
    static class Father<T extends Father>{

        private T t;

        private String f;

        public String tToString(){
            return t.toString();
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }

    static class Son extends Father<Son>{

        private String s;

        public String getS() {
            return s;
        }

        public void setS(String s) {
            this.s = s;
        }

        @Override
        public String toString() {
            return "Son{" +
                    "s='" + s + '\'' +
                    '}';
        }
    }

}
