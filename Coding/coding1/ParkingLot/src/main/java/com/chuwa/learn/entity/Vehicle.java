package com.chuwa.learn.entity;

import com.chuwa.learn.common.VehicleConstant;

import java.time.Duration;
import java.time.LocalDateTime;

public class Vehicle {
    private String plate;

    @Override
    public String toString() {
        return "Vehicle{" +
                "plate='" + plate + '\'' +
                ", entryTime=" + entryTime +
                ", size=" + size +
                '}';
    }

    private LocalDateTime entryTime;
    private Integer size;

    public Vehicle(String plate, Integer size) {
        this.plate = plate;
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public void park(ParkingLot parkingLot){
        if (this.getSize().equals(VehicleConstant.Compact) && parkingLot.getCompactSpots() > 0){
            this.setEntryTime(LocalDateTime.now());
            System.out.println("Successfully parked, enter time: " + this.getEntryTime());
            parkingLot.setCompactSpots(parkingLot.getCompactSpots() - 1);
        } else if (this.getSize().equals(VehicleConstant.Oversize) && parkingLot.getOversizeSpots() > 0) {
            this.setEntryTime(LocalDateTime.now());
            System.out.println("Successfully parked, enter time: " + this.getEntryTime());
            parkingLot.setOversizeSpots(parkingLot.getOversizeSpots() - 1);
        } else {
            System.out.println("Full parking lot.");
        }
    }

    public void leave(ParkingLot parkingLot){
        Duration duration = Duration.between(this.getEntryTime(), LocalDateTime.now());
        System.out.println("Successfully leaved, parking duration: " + duration.toSeconds() + "s");
        if (this.getSize().equals(VehicleConstant.Compact)) parkingLot.setCompactSpots(parkingLot.getCompactSpots() + 1);
        if (this.getSize().equals(VehicleConstant.Oversize)) parkingLot.setOversizeSpots(parkingLot.getOversizeSpots() + 1);
    }
}
