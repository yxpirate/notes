package com.pirate.jvmdemocode;

import sun.misc.Launcher;

/*
    在运行期，一个Java类是由该类的完全限定明（binary name）和用于加载该类的定义类加载器（defining liader）共同决定
    如果同样名字（即相同的完全限定名）的类是由两个不同的加载器所加载，那么这些类就是不同的，即便.class文件的字节码完
    全一样，并且从相同位置加载也是如此

    java -Dsun.boot.class.path=./ com.jvm.classloader.MyTest23
 */
public class MyTest23 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println("-----------------");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println("-----------------");
        System.out.println(System.getProperty("java.class.path"));

        /*
            启动类加载器（BootStrap）：
            內建于JVM,jvm启动时所运行的一块特殊机器码。
            用于java.lang.ClassLoader和其他的Java平台类，也会加载扩展类加载器与应用类加载器
            还会加载供jre正常运行所需要的基本组件，包括java.util和java.lang中的类等等。
            并不是Java类
         */

        System.out.println(ClassLoader.class.getClassLoader());
        System.out.println(Launcher.class.getClassLoader());

        System.out.println("-----------------");

//        java -Djava.system.class.loader=com.jvm.classloader.MyTest16 com.jvm.classloader.MyTest23
//        执行上面命,下面四行打印
//        com.jvm.classloader.MyTest16
//        sun.misc.Launcher$AppClassLoader@18b4aac2
//        sun.misc.Launcher$AppClassLoader@18b4aac2
//        com.jvm.classloader.MyTest16@6d06d69c
//        否则下面四行打印
//        null
//        sun.misc.Launcher$AppClassLoader@18b4aac2
//        sun.misc.Launcher$AppClassLoader@18b4aac2
//        sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(System.getProperty("java.system.class.loader"));
        System.out.println(MyTest16.class.getClassLoader());
        System.out.println(MyTest23.class.getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
