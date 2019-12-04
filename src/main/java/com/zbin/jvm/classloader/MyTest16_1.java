package com.zbin.jvm.classloader;

/**
 * com.zbin.jvm.classloader.MyTest16
 *
 * @author Zbin
 * @date 2019/12/03
 */

public class MyTest16_1 extends ClassLoader {

  public static void main(String[] args)
    throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    MyTest16 loader1 = new MyTest16("loader1");//初始类加载器
    loader1.setPath("/Users/admin/bin/test/");
    Class<?> clazz1 = loader1.loadClass("com.zbin.jvm.classloader.MyTest1");
    Object object1 = clazz1.newInstance();
    System.out.println(clazz1.hashCode());
    System.out.println(clazz1.getClassLoader());
    System.out.println("=================");

    MyTest16 loader2 = new MyTest16("loader2", loader1);
    loader2.setPath("/Users/admin/bin/test/");
    Class<?> clazz2 = loader2.loadClass("com.zbin.jvm.classloader.MyTest1");
    Object object2 = clazz2.newInstance();
    System.out.println(clazz2.hashCode());
    System.out.println(clazz2.getClassLoader());
    System.out.println("=================");//不同的命名空间加载了相同的类,两个类的hashcode不同

    MyTest16 loader3 = new MyTest16("loader3", loader2);//初始类加载器
    loader3.setPath("/Users/admin/bin/test/");
    Class<?> clazz3 = loader3.loadClass("com.zbin.jvm.classloader.MyTest1");
    Object object3 = clazz3.newInstance();
    System.out.println(clazz3.hashCode());
    System.out.println(clazz3.getClassLoader());
    System.out.println("=================");
  }
}
