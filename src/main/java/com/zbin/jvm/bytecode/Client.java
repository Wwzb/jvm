package com.zbin.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * com.zbin.jvm.bytecode.Client
 *
 * @author Zbin
 * @date 2019/12/20
 */

public class Client {

  public static void main(String[] args) {
    RealSubject rs = new RealSubject();
    InvocationHandler h = new DynamicSubject(rs);
    Class<?> clazz = rs.getClass();
    Subject subject = (Subject) Proxy
      .newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), h);
    subject.request();
  }
}
