package com.chuwa.learn.pattern.singleton;

public class SingletonDoubleCheckedLocking {
    private static volatile SingletonDoubleCheckedLocking instance; //volatile 解决多线程模式下可能出现的空指针异常

    private SingletonDoubleCheckedLocking() {
        // private constructor
    }
    public static SingletonDoubleCheckedLocking getInstance() {
        if (instance == null) {
            synchronized (SingletonDoubleCheckedLocking.class) {
                if (instance == null) {
                    instance = new SingletonDoubleCheckedLocking();
                }
            }
        }
        return instance;
    }

}
