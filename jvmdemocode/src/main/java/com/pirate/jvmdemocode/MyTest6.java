package com.pirate.jvmdemocode;
/*
    第一步Singleton.getSingleton()，调用类的静态方法。主动使用，类Singleton会初始化
    初始化之前要先准备，准备阶段为类的静态变量分配内存，并初始化为默认值(此时counter1是0，singleton是null，counter2是0)，私有方法Singleton()不执行
    然后开始初始化：给静态变量赋值。
    counter1 = 1；
    singleton = new Singleton();导致调用私有方法Singleton()。
    在Singleton()方法中counter1=1+1，counter2=0+1
    然后public static int counter2 = 9;给变量counter2赋值9
 */
public class MyTest6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();// 1
        System.out.println("main" + Singleton.counter1);
        System.out.println("main" + Singleton.counter2);
    }
}

class Singleton {
//    public static int counter1;
    public static int counter1 = 1;

//    public static int counter2 = 9;// 位置不同输出不同

    private static Singleton singleton = new Singleton();

    private Singleton() {
        counter1++;
        counter2++;
        System.out.println(counter1);
        System.out.println(counter2);
    }

    public static int counter2 = 9;

    public static Singleton getSingleton() {
        return singleton;
    }
}
