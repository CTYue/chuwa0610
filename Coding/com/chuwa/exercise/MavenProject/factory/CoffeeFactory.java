package com.chuwa.exercise.MavenProject.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * description: CoffeeFactory
 * date: 6/19/24 5:52 PM
 * author: jinhao_pang
 * version: 1.0
 */
public class CoffeeFactory {
    private static final Map<String, Coffee> cache = new HashMap<>();

    static {
        cache.put("latte", new Latte());
        cache.put("espresso", new Espresso());
    }

    public static Coffee createCoffee(String type) {
        return cache.get(type);
    }
}
