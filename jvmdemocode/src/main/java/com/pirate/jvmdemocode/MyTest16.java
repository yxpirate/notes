package com.pirate.jvmdemocode;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/*
    ClassLoader是抽象类，但是里面没有抽象方法
 */
public class MyTest16 extends ClassLoader {

    private String classLoaderName;

    private String path;

    private final String fileExtesion = ".class";

    public MyTest16(String classLoaderName) {
        super();// 将系统脸加载器当做该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);// 显示指定该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    // for MyTest23
    // java -Djava.system.class.loader=com.jvm.classloader.MyTest16 com.jvm.classloader.MyTest23
//    没有下面的构造方法,执行上面语句回报如下错误(ClassLoader SystemClassLoaderAction的run方法)
//    Error occurred during initialization of VM
//    java.lang.Error: java.lang.NoSuchMethodException: com.jvm.classloader.MyTest16.<init>(java.lang.ClassLoader)
//        at java.lang.ClassLoader.initSystemClassLoader(Unknown Source)
//        at java.lang.ClassLoader.getSystemClassLoader(Unknown Source)
//    Caused by: java.lang.NoSuchMethodException: com.jvm.classloader.MyTest16.<init>(java.lang.ClassLoader)
//        at java.lang.Class.getConstructor0(Unknown Source)
//        at java.lang.Class.getDeclaredConstructor(Unknown Source)
//        at java.lang.SystemClassLoaderAction.run(Unknown Source)
//        at java.lang.SystemClassLoaderAction.run(Unknown Source)
//        at java.security.AccessController.doPrivileged(Native Method)
//        at java.lang.ClassLoader.initSystemClassLoader(Unknown Source)
//        at java.lang.ClassLoader.getSystemClassLoader(Unknown Source)
    public MyTest16(ClassLoader parent) {
        super(parent);
    }

    public void setPath(String path) {
        this.path = path;
    }

//    @Override
//    public String toString() {
//        return "MyTest16{" +
//                "classLoaderName='" + classLoaderName + '\'' +
//                ", fileExtesion='" + fileExtesion + '\'' +
//                '}';
//    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("------> MyTest16 findClass");
        System.out.println("------> classLoaderName : " + this.classLoaderName);
        byte[] data = loadClassData(className);
        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String className) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        className = className.replace(".", "\\");
        try {
//            this.classLoaderName = this.classLoaderName.replace(".", "\\");
            is = new FileInputStream(new File(this.path + className + this.fileExtesion));
            baos = new ByteArrayOutputStream();
            int ch;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
//        test(loader1);
//        D:\codeLocalTest\myDemo\out\production\myDemo\com\jvm\classloader
//        D:\yyx
//        loader1.setPath("D:\\codeLocalTest\\myDemo\\out\\production\\myDemo\\");
        loader1.setPath("D:\\yyx\\");
        Class<?> clazz = loader1.loadClass("com.jvm.classloader.MyTest1");
        System.out.println("class hashCode: " + clazz.hashCode());
        Object object = clazz.newInstance();

        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());

        System.out.println("-----------------");

        loader1 = null;
        clazz = null;
        object = null;
        System.gc();

        loader1 = new MyTest16("loader1");
//        test(loader1);
//        D:\codeLocalTest\myDemo\out\production\myDemo\com\jvm\classloader
//        D:\yyx
//        loader1.setPath("D:\\codeLocalTest\\myDemo\\out\\production\\myDemo\\");
        loader1.setPath("D:\\yyx\\");
        clazz = loader1.loadClass("com.jvm.classloader.MyTest1");
        System.out.println("class hashCode: " + clazz.hashCode());
        object = clazz.newInstance();

        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());

        System.out.println("-----------------");

//        MyTest16 loader2 = new MyTest16(loader1, "loader2");// 这里使用不同的构造方法结果不同
////        MyTest16 loader2 = new MyTest16("loader2");
//        loader2.setPath("D:\\yyx\\");
//        Class<?> clazz2 = loader2.loadClass("com.jvm.classloader.MyTest1");
//        System.out.println("class hashCode: " + clazz2.hashCode());
//        Object object2 = clazz2.newInstance();
//
//        System.out.println(object2);
//        System.out.println(object2.getClass().getClassLoader());
//
//        System.out.println("-----------------");
//
////        MyTest16 loader3 = new MyTest16("loader3");
//        MyTest16 loader3 = new MyTest16(loader2, "loader3");
//        loader3.setPath("D:\\yyx\\");
//        Class<?> clazz3 = loader3.loadClass("com.jvm.classloader.MyTest1");
//        System.out.println("class hashCode: " + clazz3.hashCode());
//        Object object3 = clazz3.newInstance();
//
//        System.out.println(object3);
//        System.out.println(object3.getClass().getClassLoader());

    }

//    public static void test(ClassLoader classLoader) throws Exception {
//        Class<?> clazz = classLoader.loadClass("com.jvm.classloader.MyTest1");
//        Object object = clazz.newInstance();
//
//        System.out.println(object);
//        System.out.println(object.getClass().getClassLoader());
//    }

}
