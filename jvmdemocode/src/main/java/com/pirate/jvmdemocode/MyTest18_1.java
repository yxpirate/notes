package com.pirate.jvmdemocode;

public class MyTest18_1 {

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("D:\\yyx\\");

        Class<?> clazz = loader1.loadClass("com.jvm.classloader.MyTest1");
        System.out.println("class hashCode: " + clazz.hashCode());
        System.out.println("class classloader: " + clazz.getClassLoader());
    }
}
