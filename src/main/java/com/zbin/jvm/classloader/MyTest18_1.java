package com.zbin.jvm.classloader;

public class MyTest18_1 {

  public static void main(String[] args) throws ClassNotFoundException {
    MyTest16 loader1 = new MyTest16("loader1");
    loader1.setPath("/Users/admin/Desktop/");

    Class<?> clazz = loader1.loadClass("com.zbin.jvm.classloader.MyTest1");

    System.out.println("class: " + clazz.hashCode());
    System.out.println("class loader: " + clazz.getClassLoader());

    // 1. 根类加载器 /Library/Java/JavaVirtualMachines/jdk1.8.0_112.jdk/Contents/Home/jre/classes 复制class
    // 结果 class loader: null
    //由根类加载器加载了MyTest1
  }
}
