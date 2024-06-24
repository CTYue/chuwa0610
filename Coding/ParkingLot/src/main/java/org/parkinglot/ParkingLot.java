package org.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String name;
    private String address;
    private List<Floor> parkingFloors;

    public ParkingLot(){
        this.name = "";
        this.address = "";
        this.parkingFloors = new ArrayList<>();
    }

    public ParkingLot(String name, String address, List<Floor> parkingFloors) {
        this.name = name;
        this.address = address;
        this.parkingFloors = parkingFloors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Floor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<Floor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }
}
