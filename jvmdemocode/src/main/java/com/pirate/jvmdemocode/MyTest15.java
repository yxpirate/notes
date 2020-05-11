package com.pirate.jvmdemocode;

public class MyTest15 {
    public static void main(String[] args) {
        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader());

        MyTest15[] myTest15 = new MyTest15[2];
        System.out.println(myTest15.getClass().getClassLoader());

        //如果元素类型是基元类型，则数组类没有类加载器
        int[] ints = new int[1];
        System.out.println(ints.getClass().getClassLoader());
    }
}
