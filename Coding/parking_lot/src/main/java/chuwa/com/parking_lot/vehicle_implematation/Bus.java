package chuwa.com.parking_lot.vehicle_implematation;

import chuwa.com.parking_lot.Vehicle;

public class Bus extends Vehicle {
    public Bus(String licensePlate) {
        super(VehicleSize.LARGE, licensePlate);
    }
}

