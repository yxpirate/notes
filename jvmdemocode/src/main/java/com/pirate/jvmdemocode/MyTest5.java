package com.pirate.jvmdemocode;
/*
    父接口并不会因为它的子接口或实现类的初始而初始化
    只有真正使用父接口时(如引用接口中定义的常量)才会初始化
 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.b);
        System.out.println(MyChild5_.b);
        new Demo();
        new Demo();
    }
}

interface MyParent5 {
    // 如果接口MyParent5初始化，一定会创建Thread对象(new Thread())，则一定会打印出来
    public static Thread thread = new Thread() {
        {
            // 实例化代码块
            System.out.println("MyParent5");
        }
    };
}

class MyChild5 implements MyParent5 {
    public static int b = 6;
}

interface MyChild5_ extends MyParent5 {
    public static final int b = 7;
}

/////////////////////////////////
class Demo {
    {
        // 实例化块，每new一个对象执行一次
        System.out.println("Demo...");
    }

    public Demo(){
        System.out.println("Demo()");
    }
}