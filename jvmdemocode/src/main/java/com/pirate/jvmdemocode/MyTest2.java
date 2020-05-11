package com.pirate.jvmdemocode;
/*
    常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中，
    本质上，调用类没有直接引用到定义常量的类，所以不会触发定义常量的类的初始化
    常量str存放到了MyTest2的常量池中，后MyTest2与MyParent2无联系
 */
public class MyTest2 {
    public static void main(String[] args) {
        //final是否存在对静态代码块有影响
        System.out.println(MyParent2.str);
    }
}

class MyParent2 {
    public static final String str = "hello world";
    static {
        System.out.println("MyParent2 static block");
    }
}
