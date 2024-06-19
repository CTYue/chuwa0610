package com.chuwa.exercise.DesignPatterns.Factory;

public class CoffeeFactory {
    public Coffee createCoffee(String type){
        Coffee coffee = null;
        if(type.equals("Americano")){
            coffee = new AmericanoCoffee();
        } else if(type.equals("Latte")){
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("No such coffee");
        }
        return coffee;
    }
}
