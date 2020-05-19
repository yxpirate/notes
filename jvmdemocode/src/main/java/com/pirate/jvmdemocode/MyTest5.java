package com.pirate.jvmdemocode;

import java.util.UUID;

/*
    父接口并不会因为它的子接口或实现类的初始而初始化
    只有真正使用父接口时(如引用接口中定义的常量)才会初始化
 */
public class MyTest5 {
    public static void main(String[] args) {
        MyChild5 myChild5 = new MyChild5();
        System.out.println(myChild5.a);
        System.out.println("------");

        System.out.println(MyChild5.b);
        System.out.println(MyChild5_.b);

        new Demo();
        new Demo();

        System.out.println(MyParent5.b);
        System.out.println("------");

        // 父接口初始化
        System.out.println(MyParent5.str);
    }
}

interface MyParent5 {

    public static final int b = 8;

    public static final String str = UUID.randomUUID().toString();

    // 如果接口MyParent5初始化，一定会创建Thread对象(new Thread())，则一定会打印出来
    public static Thread thread = new Thread() {
        {
            // 实例化代码块
            System.out.println("MyParent5 thread");
        }
    };
}

class MyChild5 implements MyParent5 {
    public static int b = 6;

    public int a = 66;
}

interface MyChild5_ extends MyParent5 {
    public static final int b = 7;
}

/////////////////////////////////
class Demo {

    // 构造方法
    public Demo(){
        System.out.println("Demo()");
    }

    // 静态代码块，最先执行
    static {
        System.out.println("Demo static{}");
    }

    // 实例化块，每new一个对象执行一次，在构造方法之前执行
    {
        System.out.println("Demo...");
    }

}