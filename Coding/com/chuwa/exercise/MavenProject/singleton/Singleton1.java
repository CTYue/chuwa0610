package com.chuwa.exercise.MavenProject.singleton;

/**
 * description: Singleton
 * date: 6/19/24 5:38 PM
 * author: jinhao_pang
 * version: 1.0
 */
public class Singleton1 {
    private static final Singleton1 instance = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return instance;
    }
}
