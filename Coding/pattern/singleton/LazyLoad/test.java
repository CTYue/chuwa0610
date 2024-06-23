package com.chuwa.exercise.pattern.singleton.LazyLoad;

public class test {
    public static void main(String[] args) {
        lazyLoad instance = lazyLoad.getInstance();
        lazyLoad instance2 = lazyLoad.getInstance();

        System.out.println(instance == instance2);
    }
}
