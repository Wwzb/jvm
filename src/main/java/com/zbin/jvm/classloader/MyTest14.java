package com.zbin.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class MyTest14 {

  public static void main(String[] args) throws IOException {
    //上下文加载器一般也是启动类加载器
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    System.out.println(classLoader);

    String resourceName = "com/zbin/jvm/classloader/MyTest13.class";

    Enumeration<URL> urls = classLoader.getResources(resourceName);

    while (urls.hasMoreElements()) {
      URL url = urls.nextElement();
      //file:/Users/admin/Documents/myworkspace/jvm/target/classes/com/zbin/jvm/classloader/MyTest13.class
      System.out.println(url);
    }

    System.out.println("--------");

    Class<?> clazz = String.class;
    System.out.println(clazz.getClassLoader());//null

  }
}
