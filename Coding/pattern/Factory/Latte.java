package com.chuwa.exercise.pattern.Factory;

public class Latte implements Coffee {
    @Override
    public void brew() {
        System.out.println("Brewing a Latte...");
    }
}
