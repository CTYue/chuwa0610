package com.example.designpatterns;

public class Main {
    public static void main(String[] args) {
        // Get the singleton instance
        Singleton singleton = Singleton.getInstance();

        // Call methods on the singleton instance
        singleton.doSomething();
    }
}
