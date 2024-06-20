package com.chuwa.learn.pattern.singleton;

public class SingletonEager {

    private SingletonEager() {
        // private constructor
    }
    private static final SingletonEager instance = new SingletonEager();

    public static SingletonEager getInstance() {
        return instance;
    }
}
