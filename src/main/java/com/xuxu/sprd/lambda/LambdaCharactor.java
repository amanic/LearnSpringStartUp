//package com.xuxu.sprd.lambda;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
///**
// * Created by joakira on 2018/1/4.
// */
//public class LambdaCharactor {
//
//    public static void main(String[] args) {
//       /* List<String> names = Arrays.asList("sjy", "yy", "ss");
//        names.forEach(o->{
//            System.out.println(o);
//        });*/
//
//        List<String> ors = Arrays.asList("1", "2", "12", "2", "1", "34", "12", "2");
//        //Stream<Integer> integerStream = ors.stream().map(e -> new Integer(e));
//
//        List<Integer> integers = ors.stream().map(e -> new Integer(e)).filter(e -> e > 1).distinct().collect(Collectors.toList());
//        System.out.println(integers);
//
//        //统计元素出现的次数
//        Map<Integer, Integer> map = ors.stream().map(e -> new Integer(e)).filter(e -> e >= 1).collect(Collectors.groupingBy(p -> p, Collectors.summingInt(p -> 1)));
//        System.out.println(map);
//
//        //加总计算
//        Integer sum = ors.stream().map(e -> new Integer(e)).distinct().reduce(0, (x, y) -> x + y);
//        System.out.println(sum);
//
//        System.out.println("=============================");
//        ors.forEach(System.out::println);
//    }
//}
