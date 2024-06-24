package chuwa.com.parking_lot.vehicle_implematation;

import chuwa.com.parking_lot.Vehicle;

public class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        super(VehicleSize.MOTORCYCLE, licensePlate);
    }
}
