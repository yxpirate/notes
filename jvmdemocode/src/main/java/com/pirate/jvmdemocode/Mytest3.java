package com.pirate.jvmdemocode;

import java.util.UUID;

/*
    当一个常量的知在编译期间无法确定，那么其值就不会放到调用类的常量池中
    程序运行时，会导致主动使用这个常量所在的类，会导致其初始化
 */
public class Mytest3 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}

class MyParent3 {
    public static final String str = UUID.randomUUID().toString();
    static {
        System.out.println("MyParent3 static block");
    }
}
