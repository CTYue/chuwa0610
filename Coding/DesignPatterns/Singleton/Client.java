package com.chuwa.exercise.DesignPatterns.Singleton;

public class Client {
    public static void main(String[] args) {
        SingletonEL instance1 = SingletonEL.getInstance();
        SingletonEL instance2 = SingletonEL.getInstance();

        System.out.println(instance1 == instance2);

        SingletonLL instance3 = SingletonLL.getInstance();
        SingletonLL instance4 = SingletonLL.getInstance();

        System.out.println(instance3 == instance4);
    }
}
