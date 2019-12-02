package com.zbin.jvm.classloader;

//        sun.misc.Launcher$AppClassLoader@18b4aac2
//        sun.misc.Launcher$ExtClassLoader@7440e464
//        null
//系统类加载器是自定义加载器的双亲,也是启动应用的加载器
public class MyTest13 {

  public static void main(String[] args) {

    ClassLoader classLoader = ClassLoader.getSystemClassLoader();

    System.out.println(classLoader);

    while (null != classLoader) {
      classLoader = classLoader.getParent();

      System.out.println(classLoader);

    }
  }
}
