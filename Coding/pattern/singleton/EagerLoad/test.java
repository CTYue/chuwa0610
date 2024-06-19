package com.chuwa.exercise.pattern.singleton.EagerLoad;

public class test {
    public static void main(String[] args) {
        //create an instance for singleton
        eagerLoad instance = eagerLoad.getInstance();

        eagerLoad instance1 = eagerLoad.getInstance();

        //test for if there are get the same value
        System.out.println(instance == instance1);

    }
}
