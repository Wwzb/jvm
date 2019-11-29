package com.zbin.jvm.classloader;

import java.util.UUID;

/**
 * 当一个常量的值并非编译期间可以确定的,那么其值就不会被放到调用类的常量池中
 *
 * 这时在程序运行时,会导致主动使用定义这个常量的类,从而导致这个类被初始化
 */
public class MyTest3 {

  public static void main(String[] args) {
    System.out.println(MyParent3.str);
  }
}

class MyParent3 {

  public static final String str = UUID.randomUUID().toString();
//  public static final String str = "hello world";

  static {
    System.out.println("MyParent3 static block");

  }
}
