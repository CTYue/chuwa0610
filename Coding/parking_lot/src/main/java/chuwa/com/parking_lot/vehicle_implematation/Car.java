package chuwa.com.parking_lot.vehicle_implematation;

import chuwa.com.parking_lot.Vehicle;

public class Car extends Vehicle {
    public Car(String licensePlate) {
        super(VehicleSize.COMPACT, licensePlate);
    }
}
