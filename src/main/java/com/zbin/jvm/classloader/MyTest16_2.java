package com.zbin.jvm.classloader;

/**
 * com.zbin.jvm.classloader.MyTest16
 *
 * @author Zbin
 * @date 2019/12/03
 */
//jvm加入[-XX:+TraceClassUnloading]参数查看类的卸载
public class MyTest16_2 extends ClassLoader {

  public static void main(String[] args)
    throws ClassNotFoundException, IllegalAccessException, InstantiationException, InterruptedException {
    MyTest16 loader1 = new MyTest16("loader1");//初始类加载器
    loader1.setPath("/Users/admin/bin/test/");
    Class<?> clazz1 = loader1.loadClass("com.zbin.jvm.classloader.MyTest1");
    Object object1 = clazz1.newInstance();
    System.out.println(clazz1.hashCode());
    System.out.println(clazz1.getClassLoader());
    System.out.println("=================");

    loader1 = null;
    clazz1 = null;
    object1 = null;
    System.gc();//GC之后可以看到原来的类被卸载

    Thread.sleep(10000);//打开jvisualvm工具也可以查看类的卸载

    loader1 = new MyTest16("loader1");
    loader1.setPath("/Users/admin/bin/test/");
    clazz1 = loader1.loadClass("com.zbin.jvm.classloader.MyTest1");
    object1 = clazz1.newInstance();
    System.out.println(clazz1.hashCode());
    System.out.println(clazz1.getClassLoader());
    System.out.println("=================");
  }
}
