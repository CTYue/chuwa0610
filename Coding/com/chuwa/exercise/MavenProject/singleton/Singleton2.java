package com.chuwa.exercise.MavenProject.singleton;

/**
 * description: Singleton
 * date: 6/19/24 5:38 PM
 * author: jinhao_pang
 * version: 1.0
 */
public class Singleton2 {
    private static final Singleton2 instance;

    private Singleton2() {
    }

    static {
        instance = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}
