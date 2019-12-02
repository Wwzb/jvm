package com.zbin.jvm.classloader;

class CL {

  static {
    System.out.println("Class CL");
  }
}

public class MyTest12 {

  public static void main(String[] args) throws ClassNotFoundException {
    ClassLoader loader = ClassLoader.getSystemClassLoader();

    Class<?> clazz = loader.loadClass("com.zbin.jvm.classloader.CL");

    System.out.println(clazz);

    System.out.println("--------------");

    clazz = Class.forName("com.zbin.jvm.classloader.CL");

    System.out.println(clazz);
  }
}

//class com.zbin.jvm.classloader.CL
//  --------------
//  Class CL
//class com.zbin.jvm.classloader.CL
//加载类不一定会初始化该类,反射会初始化该类