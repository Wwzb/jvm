package com.zbin.jvm.classloader;

import java.util.Random;

public class MyTest8 {

  public static void main(String[] args) {
    System.out.println(FinalTest.x);
  }
}

class FinalTest {

  public static final int x = new Random().nextInt();

//  public static final int x = 3;

  static {
    System.out.println("FinalTest static block");
  }
}