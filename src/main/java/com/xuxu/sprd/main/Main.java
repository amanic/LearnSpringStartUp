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

           recursiveTraversalFolder(dir,0);



    }

//    static String newString = "";//新字符串,如果是去掉前缀后缀就留空，否则写上需要替换的字符串
//    static String oldString = "home.cnblogs.comu";//要被替换的字符串
    static String dir = "/Users/martea/Pictures/IDEA Intellij";//文件所在路径，所有文件的根目录，记得修改为你电脑上的文件所在路径

    public static void recursiveTraversalFolder(String path,Integer i) {
        File folder = new File(path);
        if (folder.exists()) {
            File[] fileArr = folder.listFiles();
            if (null == fileArr || fileArr.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                File newDir = null;//文件所在文件夹路径+新文件名
                String newName = "";//新文件名
//                String fileName = null;//旧文件名
                File parentPath = new File("");//文件所在父级路径
                for (File file : fileArr) {
                    if (file.isDirectory()) {//是文件夹，继续递归，如果需要重命名文件夹，这里可以做处理
                        System.out.println("文件夹:" + file.getAbsolutePath() + "，跳过！");
                        continue;
//                        recursiveTraversalFolder(file.getAbsolutePath());
                    }else if (file.getName().contains("Store")){
                        continue;
                    } else {//是文件，判断是否需要重命名
//                        fileName = file.getName();
                        parentPath = file.getParentFile();
//                        if (fileName.contains(oldString)) {//文件名包含需要被替换的字符串
//                            newName = fileName.replaceAll(oldString, newString);//新名字
                            newName = ""+i;
                            i++;
                            newDir = new File(parentPath + "/" + newName+".jpg");//文件所在文件夹路径+新文件名
                            file.renameTo(newDir);//重命名
                            System.out.println("修改后：" + newDir);
//                        }
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
}
