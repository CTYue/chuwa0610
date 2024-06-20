package com.chuwa.exercise.DesignPatterns.Singleton;

/**
 * @Create 06/19/2024 - 15:53
 * @Author xiao
 * @Description Only one instance for the class
 */

public class Singleton {
    /** The only one instance */
    private static final Singleton INSTANCE = new Singleton();

    /** must be private: nobody could create a instance*/
    private Singleton() {}

    public Singleton  getInstance() {
        return INSTANCE;
    }
}
