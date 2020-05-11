package com.pirate.jvmdemocode;
/*
    class [Lcom.jvm.classloader.MyParent4;
    class java.lang.Object
    class [[Lcom.jvm.classloader.MyParent4;
    class java.lang.Object
    ----
    class [I
    class java.lang.Object

    对于数组类型，其类型是有JVM在运行期动态生成的，表示为[Lcom...
    动态生成的类型的父类型时Object
 */
public class MyTest4 {
    public static void main(String[] args) {
//        MyParent4 myParent4 = new MyParent4();
//        System.out.println("--");
//        MyParent4 myParent5 = new MyParent4();

        MyParent4[] myParent4s = new MyParent4[1];
        System.out.println(myParent4s.getClass());
        System.out.println(myParent4s.getClass().getSuperclass());
//        MyParent4[] myParent4s = null;

        MyParent4[][] myParent4s1 = new MyParent4[1][1];
        System.out.println(myParent4s1.getClass());
        System.out.println(myParent4s1.getClass().getSuperclass());

        System.out.println("----");
        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());


    }
}

class MyParent4 {
    static {
        System.out.println("MyParent4 static block");
    }
}
