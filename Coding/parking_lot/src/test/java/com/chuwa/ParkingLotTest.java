package com.chuwa;
import chuwa.com.parking_lot.ParkingSpot;
import chuwa.com.parking_lot.vehicle_implematation.Bus;
import chuwa.com.parking_lot.vehicle_implematation.Car;
import chuwa.com.parking_lot.vehicle_implematation.Motorcycle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import chuwa.com.parking_lot.ParkingLot;
import chuwa.com.parking_lot.Vehicle;


public class ParkingLotTest {

    @Test
    public void testParkVehicle() {
        ParkingLot parkingLot = new ParkingLot(6);
        Vehicle car = new Car("ABC123");
        Vehicle motorcycle = new Motorcycle("GHI789");
        Vehicle bus = new Bus("JKL012");

        if (parkingLot.parkVehicle(car)){
            System.out.println("The car should be able to park");
        } else {
            System.out.println("The car should not be able to park");
        }

        if (parkingLot.parkVehicle(motorcycle)){
            System.out.println("The motorcycle should be able to park");
        } else {
            System.out.println("The motorcycle should not be able to park");
        }

        if (parkingLot.parkVehicle(bus)){
            System.out.println("The bus should be able to park");
        } else {
            System.out.println("The bus should not be able to park");
        }
    }

    @Test
    public void testLeaveSpot() {
        ParkingLot parkingLot = new ParkingLot(6);
        Vehicle car = new Car("ABC123");
        parkingLot.parkVehicle(car);
        parkingLot.leaveSpot(car);

        boolean carHasLeft = true;
        for (ParkingSpot spot : parkingLot.getSpots()) {
            if (spot.getCurrentVehicle() != null && spot.getCurrentVehicle().getLicensePlate().equals(car.getLicensePlate())) {
                carHasLeft = false;
                break;
            }
        }
        assertTrue(carHasLeft, "The car should have left the spot");
    }

    @Test
    public void testParkingFull() {
        ParkingLot parkingLot = new ParkingLot(6);
        Vehicle car1 = new Car("ABC123");
        Vehicle car2 = new Car("DEF456");
        Vehicle motorcycle1 = new Motorcycle("GHI789");
        Vehicle motorcycle2 = new Motorcycle("JKL012");
        Vehicle bus1 = new Bus("MNO345");
        Vehicle bus2 = new Bus("PQR678");

        assertTrue(parkingLot.parkVehicle(car1));
        assertTrue(parkingLot.parkVehicle(car2));
        assertTrue(parkingLot.parkVehicle(motorcycle1));
        assertTrue(parkingLot.parkVehicle(motorcycle2));
        assertTrue(parkingLot.parkVehicle(bus1));
        assertFalse(parkingLot.parkVehicle(bus2), "The parking lot should be full");
    }
}
