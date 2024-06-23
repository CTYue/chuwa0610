package com.chuwa.exercise.MavenProject.builder;

/**
 * description: Director
 * date: 6/19/24 6:13 PM
 * author: jinhao_pang
 * version: 1.0
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Bike constructor(){
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }
}
