package com.pirate.jvmdemocode;


class Parent3 {
    static int a = 3;

    static {
        System.out.println("Parent3 static");
    }

    static void doSomething() {
        System.out.println("Parent3 static doSomething");
    }
}

class Child3 extends Parent3 {

    static {
        System.out.println("Child3 static");
    }
}

/*
    子类类名调用父类的静态变量或静态方法，表示对父类的主动使用，导致父类初始化
 */
public class MyTest11 {
    public static void main(String[] args) {
//        System.out.println(Child3.a);
        System.out.println("------");
        Child3.doSomething();
    }
}
