package com.pirate.jvmdemocode;
/*
   对于静态字段，只有直接定义了该字段的类才会被初始化
   当一个类初始化时，要求其父类全部已经初始化完毕
   -XX:+TraceClassLoading,用于追踪类的加载信息并打印
 */
public class MyTest1 {
    public static void main(String[] args) {
        System.out.println(MyChild1.str);
//        System.out.println(MyChild1.str2);
    }
}

class MyParent1 {
    public static String str = "hello world";
    static {
        System.out.println("MyParent1 static block");
    }
}

class MyChild1 extends MyParent1 {
    public static String str2 = "hello world 2";
    static {
        System.out.println("MyChild1 static block");
    }
}