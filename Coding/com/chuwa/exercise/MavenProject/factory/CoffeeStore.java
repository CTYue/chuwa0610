package com.chuwa.exercise.MavenProject.factory;

/**
 * description: CofficeStore
 * date: 6/19/24 5:50 PM
 * author: jinhao_pang
 * version: 1.0
 */
public class CoffeeStore {
    public Coffee orderCoffee(String type) {
        return CoffeeFactory.createCoffee(type);
    }


}
