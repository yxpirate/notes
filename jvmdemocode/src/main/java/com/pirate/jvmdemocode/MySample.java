package com.pirate.jvmdemocode;

public class MySample {

    public MySample() {
        System.out.println("MySample ClassLoader: " + this.getClass().getClassLoader());

        new MyCat();

        System.out.println("MySample : " + MyCat.class);
    }
}
