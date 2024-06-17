package com.chuwa.learn;

import com.chuwa.learn.common.VehicleConstant;
import com.chuwa.learn.entity.ParkingLot;
import com.chuwa.learn.entity.Vehicle;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParkingLot parkingLot = new ParkingLot(50, 100);
        Vehicle vehicle1 = new Vehicle("NY12345", VehicleConstant.Compact);
        Vehicle vehicle2 = new Vehicle("NY12346", VehicleConstant.Oversize);
        Vehicle vehicle3 = new Vehicle("NY12347", VehicleConstant.Compact);
        System.out.println(vehicle1);

        vehicle1.park(parkingLot);
        Thread.sleep(2000);
        vehicle1.leave(parkingLot);
        vehicle2.park(parkingLot);
        vehicle3.park(parkingLot);
        Thread.sleep(3000);
        vehicle3.leave(parkingLot);
        vehicle2.leave(parkingLot);
    }
}