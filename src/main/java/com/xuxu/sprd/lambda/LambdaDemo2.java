//package com.xuxu.sprd.lambda;
//
///**
// * Created by joakira on 2018/1/4.
// */
//public class LambdaDemo2 {
//
//    public static void main(String[] args) {
//        Runnable r1 = () -> {System.out.println("Hello Lambda!");};
//        r1.run();
//
//        Lb lb=(int x, int y) -> x+y;
//        int rest = lb.play(1, 2);
//        System.out.println(rest);
//
//        System.out.println( useLambda((int x, int y) -> x-y));
//    }
//
//    private static int useLambda(Lb l) {
//        return l.play(2,3);
//    }
//
//
//}
//
//interface Lb{
//    int play(int x , int y);
//}
