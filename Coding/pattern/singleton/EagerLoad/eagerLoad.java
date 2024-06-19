package com.chuwa.exercise.pattern.singleton.EagerLoad;

//This is a Eager_load singleton design pattern, classname: demo1_Eager_load
public class eagerLoad {

    // Step 1: Creating a private static instance of the class
    private static final eagerLoad instance = new eagerLoad();

    // Step 2: Private constructor to prevent instantiation
    private eagerLoad() {}

    // Step 3: Public method to provide access to the instance
    public static eagerLoad getInstance() {
        return instance;
    }


    // instance created at the time of class loading, thread-safe, maybe little bit use of memory

}
