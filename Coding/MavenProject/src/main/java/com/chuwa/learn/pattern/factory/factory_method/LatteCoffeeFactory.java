package com.chuwa.learn.pattern.factory.factory_method;
public class LatteCoffeeFactory implements CoffeeFactory {

    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}