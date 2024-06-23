package com.chuwa.exercise.genericsPractice;

import java.util.ArrayList;

// practice generic class
/*
a generic class is basically make you do the same duplicate function or behavior
with different to avoid you to create same functional class but for different types
*/
//<T> standing for type
public class Printer <T> {
    T thingToPrint;

    public Printer(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println("Generic example: " + thingToPrint);

    }
}
