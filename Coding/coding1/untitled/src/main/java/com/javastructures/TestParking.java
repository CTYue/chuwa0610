package com.javastructures;

import com.javastructures.exception.InvalidVehicleNumberException;
import com.javastructures.exception.ParkingFullException;
import com.javastructures.model.Ticket;
import com.javastructures.model.Vehicle;
import com.javastructures.model.VehicleSize;
import com.javastructures.service.ParkingLot;
import com.javastructures.strategy.FourWheelerWeekDayChargeStrategy;
import com.javastructures.strategy.TwoWheelerWeekDayChargeStrategy;

// https://medium.com/geekculture/system-design-parking-lot-design-interview-question-using-java-3d1dea4f6a2

public class TestParking {
    public static void main(String[] args) throws ParkingFullException, InvalidVehicleNumberException {
        ParkingLot parkingLot = ParkingLot.getParkingLot();

        parkingLot.initializeParkingSlots(10, 10); // 10 two wheel parking and 10 four wheel parking

        Vehicle vehicle = new Vehicle("Mh12", VehicleSize.TWOWHEELER);

        Ticket ticket = parkingLot.park(vehicle);
        System.out.println(ticket);

        Vehicle vehicle2 = new Vehicle("Mh13", VehicleSize.FOURWHEELER);

        Ticket ticket2 = parkingLot.park(vehicle2);
        System.out.println(ticket2);

        int cost1 = parkingLot.unPark(ticket, new TwoWheelerWeekDayChargeStrategy());
        System.out.println(cost1);

        int cost2 = parkingLot.unPark(ticket2, new FourWheelerWeekDayChargeStrategy());
        System.out.println(cost2);

    }
}
