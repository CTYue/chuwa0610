package com.chuwa.exercise.DesignPatterns.Singleton;

/**
 * Singleton Lazy Load
 */
public class SingletonLL {
    private SingletonLL(){}

    private static SingletonLL instance;

    static {
        instance = new SingletonLL();
    }

    public static SingletonLL getInstance(){
        return instance;
    }
}
