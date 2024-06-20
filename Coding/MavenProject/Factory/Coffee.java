package com.chuwa.exercise.collection.Factory;

public abstract class Coffee {
    public abstract String getName();

    //加糖
    public void addsugar() {
        System.out.println("sugar");
    }

    //加奶
    public void addMilk() {
        System.out.println("milk");
    }
}
