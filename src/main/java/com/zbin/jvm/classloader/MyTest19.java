package com.zbin.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

public class MyTest19 {

  public static void main(String[] args) {
    AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();

    System.out.println(aesKeyGenerator.getClass().getClassLoader());

    System.out.println(MyTest19.class.getClassLoader());

    // java -Djava.ext.dirs=./ com.zbin.jvm.classloader.MyTest19
    // 将当前扩展目录修改为我们的类目录,会报错
    // Caused by: java.lang.ClassNotFoundException: com.sun.crypto.provider.AESKeyGenerator

  }
}
