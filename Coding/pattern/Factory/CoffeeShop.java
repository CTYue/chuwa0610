package com.chuwa.exercise.pattern.Factory;

public class CoffeeShop {
    public static void main(String[] args) {
        CoffeeFactory coffeeFactory = new SimpleCoffeeFactory();

        Coffee espresso = coffeeFactory.orderCoffee("espresso");
        Coffee cappuccino = coffeeFactory.orderCoffee("cappuccino");
        Coffee latte = coffeeFactory.orderCoffee("latte");
    }
}
