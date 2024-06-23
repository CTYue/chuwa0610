package com.chuwa.learn.pattern.singleton;

public class Client {
    SingletonEager instance = SingletonEager.getInstance();
    SingletonEager instance2 = SingletonEager.getInstance();
    // System.out.println(instance == instance2);  // true
}
