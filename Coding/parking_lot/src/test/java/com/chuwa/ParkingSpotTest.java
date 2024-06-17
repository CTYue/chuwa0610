package com.chuwa;

import chuwa.com.parking_lot.ParkingSpot;
import chuwa.com.parking_lot.Vehicle;
import chuwa.com.parking_lot.vehicle_implematation.Car;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingSpotTest {

    @Test
    public void testParkVehicle() {
        ParkingSpot spot = new ParkingSpot(Vehicle.VehicleSize.COMPACT);
        Vehicle car = new Car("ABC123");

        if (spot.park(car)){
            System.out.println("The car should be able to park in a compact spot");
        } else {
            System.out.println("The car should not be able to park in a compact spot");
        }
    }

    @Test
    public void testLeaveSpot() {
        ParkingSpot spot = new ParkingSpot(Vehicle.VehicleSize.COMPACT);
        Vehicle car = new Car("ABC123");

        spot.park(car);
        spot.leave();
        if (spot.isAvailable()){
            System.out.println("The spot is available");
        } else {
            System.out.println("The spot is not available");
        }
    }
}

