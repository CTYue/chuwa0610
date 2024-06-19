package com.chuwa.exercise.MavenProject.builder;

/**
 * description: MobileBuilder
 * date: 6/19/24 6:10 PM
 * author: jinhao_pang
 * version: 1.0
 */
public class OfoBuilder extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("carbon fibre ofo");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("leather ofo");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
