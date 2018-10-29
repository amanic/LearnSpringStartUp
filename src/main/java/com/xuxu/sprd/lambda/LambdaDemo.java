//package com.xuxu.sprd.lambda;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
///**
// * Created by joakira on 2018/1/4.
// */
//public class LambdaDemo {
//
//    public static void main(String[] args) {
//        List<String> ls = Arrays.asList("sjy","yy","ss");
//
//
//      /*  Collections.sort(ls, new Comparator<String>() {
//            @Override
//            public int compare(String a, String b) {
//                return b.compareTo(a);
//            }
//        });*/
//
//        //lambda1
//        Collections.sort(ls,(String a, String b) ->{
//            return b.compareTo(a);
//        });
//
//        //lambda2
//       // Collections.sort(ls,(String a, String b) -> b.compareTo(a));
//
//        System.out.println(ls);
//    }
//
//}
