package com.chuwa.exercise.collection.Builder;

public class OfoBuilder extends Builder {
    public void buildFrame(){
        bike.setFrame("铝合金");
    }
    public void buildSeat(){
        bike.setSeat("皮革");
    }
    public Bike createBike(){
        return bike;
    }
}
