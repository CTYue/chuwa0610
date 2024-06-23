package com.chuwa.exercise.genericsPractice;


import java.util.ArrayList;
import java.util.List;

// do not use for primitive type etc., int
public class PrinterTest {
    public static void main(String[] args) {
        Printer<Integer> printer = new Printer<>( 44);
        printer.print();

        Printer<String> printer2 = new Printer<>( "Howard");
        printer2.print();


        shout("Howard");
        shout(55555);

        List<Integer> intListTest = new ArrayList<>();
        intListTest.add(1);
        intListTest.add(2);
        printList(intListTest);
    }


    //practice with generic method
    private static <T> void shout(T shout){
        System.out.println("this is a generic shout method example ");
        System.out.println("Test for the shout: " + shout);
    }


    private static void printList(List<?> list){
        System.out.println();
    }
}
