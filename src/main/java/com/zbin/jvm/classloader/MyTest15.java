package com.zbin.jvm.classloader;

public class MyTest15 {

  public static void main(String[] args) {
    String[] strings = new String[2];
    System.out.println(strings.getClass());//class [Ljava.lang.String;
    System.out.println(strings.getClass().getClassLoader());//null 代表其类加载器是根类加载器

    System.out.println("----------");

    MyTest15[] myTest15s = new MyTest15[2];
    System.out.println(
      myTest15s.getClass()
        .getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2 与数组元素的类加载器一致

    System.out.println("------------");

    int[] arrays = new int[23];
    System.out.println(arrays.getClass().getClassLoader());//null 但是代表没有类加载器
  }
}
