package com.zbin.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import lombok.Setter;

/**
 * com.zbin.jvm.classloader.MyTest16
 *
 * @author Zbin
 * @date 2019/12/03
 */

public class MyTest16 extends ClassLoader {

  public String classLoaderName;

  @Setter
  private String path;

  public MyTest16(String classLoaderName) {
    super();
    this.classLoaderName = classLoaderName;
  }

  public MyTest16(String classLoaderName, ClassLoader parent) {
    super(parent);
    this.classLoaderName = classLoaderName;
  }

  @Override
  protected Class<?> findClass(String className) {
    System.out
      .println("findClass invoked: " + className + ", classLoaderName: " + this.classLoaderName);
    byte[] source = this.loadClassData(className);
    return this.defineClass(className, source, 0, source.length);
  }

  private byte[] loadClassData(String className) {
    className = className.replace(".", "/");
    String classExtension = ".class";
    byte[] data = null;
    try (InputStream is = new FileInputStream(this.path + new File(className + classExtension));
      ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
      int ch;
      while ((ch = is.read()) != -1) {
        baos.write(ch);
      }
      data = baos.toByteArray();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return data;
  }

  private static void test(ClassLoader classLoader)
    throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    Class<?> clazz = classLoader.loadClass("com.zbin.jvm.classloader.MyTest1");
    Object object = clazz.newInstance();
    System.out.println(object);
    System.out.println(object.getClass().getClassLoader());
  }

  public static void main(String[] args)
    throws IllegalAccessException, InstantiationException, ClassNotFoundException {
    MyTest16 loader1 = new MyTest16("loader1");
    loader1.setPath("/Users/admin/bin/test/");
    test(loader1);
  }
}
