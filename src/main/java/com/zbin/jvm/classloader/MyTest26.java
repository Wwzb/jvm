package com.zbin.jvm.classloader;

import java.sql.Driver;
import java.util.ServiceLoader;

public class MyTest26 {

  public static void main(String[] args) {
    //注释掉下面这行之后就无法再记载Mysql的驱动,扩展类加载器无法加载我们的类目录
    //Thread.currentThread().setContextClassLoader(MyTest26.class.getClassLoader().getParent());

    ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);

    for (Driver driver : loader) {
      System.out.println(
        "driver : " + driver.getClass() + ",loader : " + driver.getClass().getClassLoader());
    }

    System.out.println("当前线程上下文类加载器：" + Thread.currentThread().getContextClassLoader());

    System.out.println("ServiceLoader的类加载器：" + ServiceLoader.class.getClassLoader());

  }
}
