package com.chuwa.learn.entity;

public class ParkingLot {
    private Integer compactSpots;
    private Integer oversizeSpots;

    public ParkingLot(Integer oversizeSpots, Integer compactSpots) {
        this.oversizeSpots = oversizeSpots;
        this.compactSpots = compactSpots;
    }

    public Integer getCompactSpots() {
        return compactSpots;
    }

    public void setCompactSpots(Integer compactSpots) {
        this.compactSpots = compactSpots;
    }

    public Integer getOversizeSpots() {
        return oversizeSpots;
    }

    public void setOversizeSpots(Integer oversizeSpots) {
        this.oversizeSpots = oversizeSpots;
    }

}
