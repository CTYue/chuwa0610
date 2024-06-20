package com.chuwa.exercise.collection.Builder;

public class MobileBuilder extends Builder{
    public void buildFrame() {
        bike.setFrame("铝合金");
    }
    public void buildSeat() {
        bike.setSeat("橡胶");
    }
    public Bike createBike() {
        return bike;
    }
}
