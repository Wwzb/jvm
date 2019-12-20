package com.zbin.jvm.bytecode;

/**
 * com.zbin.jvm.bytecode.RealSubject
 *
 * @author Zbin
 * @date 2019/12/20
 */

public class RealSubject implements Subject {

  @Override
  public void request() {
    System.out.println("From RealSubject");
  }

}
