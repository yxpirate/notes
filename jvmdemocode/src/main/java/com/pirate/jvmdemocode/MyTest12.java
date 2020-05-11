package com.pirate.jvmdemocode;


class CL {
    static {
        System.out.println("CL static");
    }
}

/*
    调用ClassLoader类的loadClass方法加载一个类，不是对类的主动使用，不会初始化
 */
public class MyTest12 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();

        Class<?> clazz = loader.loadClass("com.jvm.classloader.CL");//不会导致CL类的初始化

        System.out.println(clazz);

        System.out.println("-------");

        clazz = Class.forName("com.jvm.classloader.CL");// 反射导致类的初始化

        System.out.println(clazz);
    }
}
