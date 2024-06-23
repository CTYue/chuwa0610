package com.chuwa.exercise.pattern.singleton.LazyLoad;

import com.chuwa.tutorial.t04_design_pattern.singleton.enumclass.Singleton;

// Lazy load singleton design pattern
public class lazyLoad {

    // Step 1: Private constructor to prevent instantiation
    private lazyLoad() {}

    // Step 2: Private static instance variable
    private static lazyLoad instance;

    // Step 3: Public method to provide access to the instance
    public static synchronized lazyLoad getInstance() {
        if (instance == null) {
            instance = new lazyLoad();
        }
        return instance;
    }

    //will create the instance when we first use it , with synchronized is thread safe
}


