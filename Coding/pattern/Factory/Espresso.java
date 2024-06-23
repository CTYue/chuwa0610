package com.chuwa.exercise.pattern.Factory;

//Step 2: Implement Concrete Coffee Classes (Concrete Products)
//Next, we create concrete classes for each type of coffee, implementing the Coffee interface.
public class Espresso implements Coffee {
    @Override
    public void brew() {
        System.out.println("Brewing an Espresso...");
    }
}
