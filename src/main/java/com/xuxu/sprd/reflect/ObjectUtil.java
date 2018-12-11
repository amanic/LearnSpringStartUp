package com.xuxu.sprd.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于对Object进行解析并且转换成Map键值对的形式
 * 建议使用者做个测试
 * Created by martea on 2018/12/11.
 */
public class ObjectUtil {

    private static final String JAVAP = "java.";


    /**
     * 利用递归调用将Object中的值全部进行获取
     *
     * @param obj           对象
     * @return obj转化为map，涉及到时间的时候默认都转为yyyy-MM-dd HH:m   m:ss
     * 如果已经带时分秒，则直接返回如上各式，如果不带时分秒，则返回会加上00:00:00或者23:59:59
     * 请结合{@link ToMapEX}使用
     * @throws IllegalAccessException
     */
    public static Map<String, String> objectToMapString(Object obj) throws IllegalAccessException ,ParseException{
        Map<String, String> map = new HashMap();
        objectTransfer(obj, map);
        return map;
    }


    /**
     * 递归调用函数
     *
     * @param obj           对象
     * @param map           map
     * @return
     * @throws IllegalAccessException
     */
    private static Map<String, String> objectTransfer(Object obj, Map<String, String> map) throws IllegalAccessException, ParseException {
        Class<?> clazz = obj.getClass();
        //获取所有属性
        for (Field field : clazz.getDeclaredFields()) {
            //设置属性可以被访问
            field.setAccessible(true);
            if (field.isAnnotationPresent(ToMapEX.class)){
                for (Annotation anno : field.getDeclaredAnnotations()){
                    //如果加了ToMapEx注解
                    if(anno.annotationType().equals(ToMapEX.class)){
                        if(!((ToMapEX) anno).required()){
                            break;
                        }
                        //如果是null或者不用放到map的值(notConvertWhen)
                        if(null==field.get(obj)||field.get(obj).toString().equals(((ToMapEX) anno).notConvertWhen())){
                            break;
                        }
                        //如果是**开始时间
                        String s = field.get(obj).toString();
                        if(((ToMapEX) anno).isStart()){
                            SimpleDateFormat slf = new SimpleDateFormat(((ToMapEX) anno).dateStyle());
                            s = formStartAndEndTime(slf.parse(field.get(obj).toString()),((ToMapEX) anno).dateStyle(),true);
                        }else if(((ToMapEX) anno).isEnd()){//如果是**结束时间
                            SimpleDateFormat slf = new SimpleDateFormat(((ToMapEX) anno).dateStyle());
                            s = formStartAndEndTime(slf.parse(field.get(obj).toString()),((ToMapEX) anno).dateStyle(),false);
                        }
                        //判断是否有需要放到map里面的别名
                        if(!((ToMapEX) anno).value().trim().equals("")){
                            map.put(((ToMapEX) anno).value(),s);
                        }else {
                            map.put(field.getName(),s);
                        }
                        break;
                    }
                }
                continue;
            }
            String fieldName = /*clazz.getSimpleName() + "." + */field.getName();
            Object value = field.get(obj);
            if(null==value){
                continue;
            }
            Class<?> valueClass = value.getClass();
            if (valueClass.isPrimitive()) {
                map.put(fieldName, value.toString());

            } else if (valueClass.getName().contains(JAVAP)) {
                map.put(fieldName, value.toString());
            } else {
                objectTransfer(value, map);
            }
        }
        return map;
    }

    /**
     * 用来将时间转化为字符串，一般使用于对象转为map时，start和end的处理
     * 如果传入的时间格式已经带有':'这个符号，则会直接返回
     * @param d 传入的时间
     * @param sourceFormat 传入的时间格式
     * @param isStart true为开始时间，false为结束时间
     * @return 统一返回 yyyy-MM-dd HH:mm:ss格式
     */
    public static String formStartAndEndTime(Date d, String sourceFormat, boolean isStart) {
        if(sourceFormat.contains(":")){
            DateFormat format1 = new SimpleDateFormat(sourceFormat);
            return format1.format(d);
        }else {
            DateFormat format1 = new SimpleDateFormat(sourceFormat);
            if(isStart){
                return format1.format(d) + " 00:00:00";
            }else {
                return format1.format(d) + " 23:59:59";
            }
        }

    }


    /**
     * 测试用例
     * @param args
     * @throws IllegalAccessException
     * @throws ParseException
     */
    public static void main(String[] args) throws IllegalAccessException, ParseException {
        Person person = new Person();
        person.setAge(1);
        person.setName("martea");
        person.setRemark("remark");
        person.setStartBirthDay("2018-09-09 09:09:09");
        person.setEndBirthDay("2018-09-10");
        School school = new School();
        school.setAddress("火星");
        school.setCname("学校");
        person.setSchool(school);
        Map map = objectToMapString(person);
        System.out.println(map);
    }

}