package com.chuwa.exercise.MavenProject.factory;

/**
 * description: Main
 * date: 6/19/24 5:58 PM
 * author: jinhao_pang
 * version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee latte = coffeeStore.orderCoffee("latte");
        System.out.println(latte.getName());

        Coffee espresso = coffeeStore.orderCoffee("espresso");
        System.out.println(espresso.getName());
    }
}
