package com.chuwa.exercise.pattern.Factory;

public abstract class CoffeeFactory {
    public abstract Coffee createCoffee(String type);

    public Coffee orderCoffee(String type) {
        Coffee coffee = createCoffee(type);
        coffee.brew();
        return coffee;
    }
}
