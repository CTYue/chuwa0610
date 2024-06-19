package com.chuwa.exercise.pattern.Factory;

public class SimpleCoffeeFactory extends CoffeeFactory {
    @Override
    public Coffee createCoffee(String type) {
        switch (type.toLowerCase()) {
            case "espresso":
                return new Espresso();
            case "cappuccino":
                return new Cappuccino();
            case "latte":
                return new Latte();
            default:
                throw new IllegalArgumentException("Unknown coffee type: " + type);
        }
    }
}
