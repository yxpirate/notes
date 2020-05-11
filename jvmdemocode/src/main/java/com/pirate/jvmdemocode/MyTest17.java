package com.pirate.jvmdemocode;

public class MyTest17 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");

        Class<?> clazz = loader1.loadClass("com.jvm.classloader.MySample");

        System.out.println("class hashCode: " + clazz.hashCode());

        // 下面这行代码实例化MySample对象。即MySample构造方法不会调用
        // 因此不会执行new Cat();也就不会实例化MyCat对象，就没有主动使用MyCat，这里就不会加载MyCat Class
        Object object = clazz.newInstance();
    }
}
