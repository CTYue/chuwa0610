package com.chuwa.learn.default_interface_method;
/**
 *
 * default 和 static interface 中的方法有方法体
 * */
public interface DIML {
    static final String BLOG = "is Chuwa a";
    int add(int a, int b);
    default int substract(int a, int b){return a - b;}
    static String blogName(){
        return BLOG;
    }
}
