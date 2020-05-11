package com.pirate.jvmdemocode;


class Parent {
    static int a = 3;

    static {
        System.out.println("Parent static");
    }
}

class Child extends Parent {
    static int b = 4;

    static {
        System.out.println("Child static");
    }
}

public class MyTest9 {
    static {
        System.out.println("MyTest9 static");
    }

    public static void main(String[] args) {
        System.out.println(Child.b);
    }
}
