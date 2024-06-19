package com.chuwa.exercise.pattern.Factory;

public class Cappuccino implements Coffee {
    @Override
    public void brew() {
        System.out.println("Brewing a Cappuccino...");
    }
}
