package com.chuwa.learn.pattern.singleton.demo2;

public class Singleton {
    // private constructor
    private Singleton() {}

    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    public static Singleton getInstance() {
        return instance;
    }

}
