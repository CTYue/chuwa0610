package com.chuwa.exercise.MavenProject.builder;

/**
 * description: Builder
 * date: 6/19/24 6:08 PM
 * author: jinhao_pang
 * version: 1.0
 */
public abstract class Builder {
    protected Bike bike = new Bike();

    public abstract void buildFrame();

    public abstract void buildSeat();

    public abstract Bike createBike();
}
