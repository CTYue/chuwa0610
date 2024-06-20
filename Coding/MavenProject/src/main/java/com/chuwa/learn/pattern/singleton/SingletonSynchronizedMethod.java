package com.chuwa.learn.pattern.singleton;

public class SingletonSynchronizedMethod {
    private static SingletonSynchronizedMethod instance;

    private SingletonSynchronizedMethod() {
        // private constructor
    }

    public static synchronized SingletonSynchronizedMethod getInstance() {
        // only create when previous creation of singleton
        if (instance == null) {
            instance = new SingletonSynchronizedMethod();
        }
        return instance;
    }
}
