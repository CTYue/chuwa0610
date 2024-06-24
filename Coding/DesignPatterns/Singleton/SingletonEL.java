package com.chuwa.exercise.DesignPatterns.Singleton;

/**
 * Singleton Eager Load
 */
public class SingletonEL {
    private SingletonEL(){}

    private static SingletonEL instance = new SingletonEL();

    public static SingletonEL getInstance(){
        return instance;
    }

}
