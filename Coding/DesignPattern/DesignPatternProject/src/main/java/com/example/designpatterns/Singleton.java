package com.example.designpatterns;

public class Singleton {

    // Static member variable to hold the single instance of the class
    private static Singleton instance;

    // Private constructor to prevent instantiation from outside the class
    private Singleton() {
        // Optional: You can initialize instance variables here if needed
    }

    // Static method to get the singleton instance
    public static Singleton getInstance() {
        // Lazy initialization: Create instance if not already instantiated
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Optional: Add other methods or instance variables as needed

    // Example method
    public void doSomething() {
        System.out.println("Singleton instance is doing something.");
    }
}
