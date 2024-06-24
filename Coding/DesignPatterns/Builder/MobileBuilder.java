package com.chuwa.exercise.DesignPatterns.Builder;

public class MobileBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("CarbonFiber Frame");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Leather Seat");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
