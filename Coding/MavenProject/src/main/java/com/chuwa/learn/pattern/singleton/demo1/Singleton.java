package com.chuwa.learn.pattern.singleton.demo1;

/**
 * @Descripton:
 *      Eager Initialization
 */
public class Singleton {
    // private constructor
    private Singleton() {}

    private static Singleton singletonInstance = new Singleton();

    public static Singleton getInstance() {
        return singletonInstance;
    }
}
