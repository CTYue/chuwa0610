package com.chuwa.exercise.MavenProject.builder;

/**
 * description: Main
 * date: 6/19/24 6:15 PM
 * author: jinhao_pang
 * version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        MobileBuilder mobileBuilder = new MobileBuilder();
        Director director = new Director(mobileBuilder);
        Bike bike = director.constructor();
        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());


    }
}
