package com.chuwa.exercise.collection;

import java.util.Optional;

/**
 * description: Main
 * date: 6/19/24 5:13 PM
 * author: jinhao_pang
 * version: 1.0
 */
public class Main {

    public static void main(String[] args) {

        // one
//        int a = 0;
//        int b = 3;
//        String s = null;
//        try {
//            System.out.println(b / a);
//            System.out.println(s.equals("aa"));
//            throw new RuntimeException();
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.getMessage();
//        }
//        System.out.println("End ...");

        // two

//        int a = 0;
//        int b = 3;
//        String s = null;
//        try {
//            // System.out.println(b / a);
//            System.out.println(s.equals("aa"));
//            throw new RuntimeException();
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//        }

        // three
//        int a = 0;
//        int b = 3;
//        String s = null;
//        try {
//            // System.out.println(b / a);
//            // System.out.println(s.equals("aa"));
//            throw new RuntimeException();
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.getMessage();
//        }
//        System.out.println("End ...");

        String a = null;
        String s = Optional.ofNullable(a).orElse("aaa");
        System.out.println(s);
    }
}
