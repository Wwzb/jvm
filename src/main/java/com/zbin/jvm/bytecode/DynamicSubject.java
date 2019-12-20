package com.zbin.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * com.zbin.jvm.bytecode.DynamicSubject
 *
 * @author Zbin
 * @date 2019/12/20
 */

public class DynamicSubject implements InvocationHandler {

  private Object sub;

  DynamicSubject(Object sub) {
    this.sub = sub;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("Before calling>>>" + method);
    method.invoke(sub, args);
    System.out.println("After calling>>>" + method);
    return null;
  }
}
