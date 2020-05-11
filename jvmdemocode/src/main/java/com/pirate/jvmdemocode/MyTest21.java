package com.pirate.jvmdemocode;

import java.lang.reflect.Method;

/*
    类加载器双亲委托模型的好处：
    1，可以确保Java核心库的类型安全。所有的java应用都会引用java.lang.Object类，即在运行期，java.lang.Object类会被加载到java虚拟
    机；如果这个加载过程有自定义加载器完成，那么很可能汇总JVM中存在多个版本的java.lang.Object类，且这些类之间不兼容，互相不可见
    （命名空间的作用）
    借助双亲委托机制，Java核心类库中的类加载工作有启动类加载器统一完成，从而确保了Java应用所使用的都是同一个版本的Java核心类库，互相之间兼容
    2，确保Java核心类库所提供的类不会被自定义的类替代
    3，不同的类加载器可以为相同名称（binary name）的类创建额外的命名空间。相同名称的类可并存在Java虚拟机中，只需要用不同的类加载器
    来加载他们即可。
    不同的类加载器所加载的类之间不兼容，这就相当于在java虚拟机内部创建了一个又一个相互隔离的java类空间（很多框架中使用这类技术）
 */
public class MyTest21 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        loader1.setPath("D:\\yyx\\");
        loader2.setPath("D:\\yyx\\");

        Class<?> clazz1 = loader1.loadClass("com.jvm.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.jvm.classloader.MyPerson");

        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);

    }
}
