package com.pirate.jvmdemocode;

public class MyCat {

    public MyCat() {
        System.out.println("MyCat ClassLoader: " + this.getClass().getClassLoader());

        System.out.println("MyCat : " + MySample.class);
    }
}
