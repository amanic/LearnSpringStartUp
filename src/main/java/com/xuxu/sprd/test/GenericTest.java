package com.xuxu.sprd.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by martea on 2018/12/20.
 */
public class GenericTest {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 其实不管泛型，getclass还是同一个类型
     */
    public static void test2() {
        Box<String> name = new Box<String>("corn");
        Box<Integer> age = new Box<Integer>(712);

        System.out.println("name class:" + name.getClass());      // com.qqyumidi.Box
        System.out.println("age class:" + age.getClass());        // com.qqyumidi.Box
        System.out.println(name.getClass() == age.getClass());    // true
    }

    /**
     * 泛型的诞生
     */
    public static void test1() {
            /*
        List list = new ArrayList();
        list.add("qqyumidi");
        list.add("corn");
        list.add(100);
        */

        List<String> list = new ArrayList<String>();
        list.add("qqyumidi");
        list.add("corn");
        //list.add(100);   // 1  提示编译错误

        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i); // 2
            System.out.println("name:" + name);
        }
    }

    /**
     * 通配符的诞生
     * 类型通配符一般是使用 ? 代替具体的类型实参。注意了，此处是类型实参，而不是类型形参！
     * 且Box<?>在逻辑上是Box<Integer>、Box<Number>...等所有Box<具体类型实参>的父类。
     * 由此，我们依然可以定义泛型方法，来完成此类需求。
     */
    public static void test3() {
        Box<String> name = new Box<String>("corn");
        Box<Integer> age = new Box<Integer>(712);
        Box<Number> number = new Box<Number>(314);

        getData(name);
        getData(age);
        getData(number);
    }


    /**
     * 有时候，我们还可能听到类型通配符上限和类型通配符下限。具体有是怎么样的呢？
     * 在上面的例子中，如果需要定义一个功能类似于getData()的方法，但对类型实参又有进一步的限制：只能是Number类及其子类。
     * 此时，需要用到类型通配符上限。
     * 这里讲的是上限，意思是只能接受（T extends X） X的子类泛型
     * 如果是下限的话，意思就是只能接受（T extends Y）Y的父类泛型
     */
    public static void test4() {
        Box<String> name = new Box<String>("corn");
        Box<Integer> age = new Box<Integer>(712);
        Box<Number> number = new Box<Number>(314);

        getData(name);
        getData(age);
        getData(number);

        //getUpperNumberData(name); // 1 这里会报错
        getUpperNumberData(age);    // 2
        getUpperNumberData(number); // 3
    }

    public static void getData(Box<?> data) {
        System.out.println("data :" + data.getData());
    }

    public static void getUpperNumberData(Box<? extends Number> data) {
        System.out.println("data :" + data.getData());
    }

}


class Box<T> {

    private T data;

    public Box() {

    }

    public Box(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}





