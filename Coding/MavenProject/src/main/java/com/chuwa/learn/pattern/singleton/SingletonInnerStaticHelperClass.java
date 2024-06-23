package com.chuwa.learn.pattern.singleton;

public class SingletonInnerStaticHelperClass {
    private SingletonInnerStaticHelperClass() {
        // private constructor
    }

    private static class SingletonHelper {
        private static final SingletonInnerStaticHelperClass INSTANCE = new SingletonInnerStaticHelperClass();
    }

    public static SingletonInnerStaticHelperClass getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
