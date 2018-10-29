//package com.xuxu.sprd.lambda;
//
//import java.util.concurrent.Callable;
//
///**
// * Created by joakira on 2018/1/4.
// */
//public class LambdaCondition {
//    public static void main(String[] args) {
//
//        //复合lambda
//        Callable<Runnable> c=()->()->{
//            System.out.println("Nested lambda");
//        };
//
//        try {
//            c.call().run();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        Callable<Integer> c2 = false ? (() -> 42) : (() -> 24);
//        try {
//            System.out.println(c2.call());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        //System.out::println
//
//    }
//}
