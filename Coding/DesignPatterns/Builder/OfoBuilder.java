package com.chuwa.exercise.DesignPatterns.Builder;

public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("Aluminium Frame");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Rubber Seat");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
