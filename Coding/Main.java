package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3, 4, 6, "220 Fifth Ave");
        List<Vehicle> ls = new ArrayList<>();
        Car car1 = new Car("AAAA");
        Car car2 = new Car("BBBB");
        Car car3 = new Car("CCCC");
        Truck truck1 = new Truck("1111");
        Truck truck2 = new Truck("2222");
        Truck truck3 = new Truck("3333");
        Truck truck4 = new Truck("4444");
        ls.add(car1);
        ls.add(car2);
        ls.add(car3);
        ls.add(truck1);
        ls.add(truck2);
        ls.add(truck3);
        ls.add(truck4);

        for(Vehicle vehicle : ls){
            parkingLot.park(vehicle);
        }

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 6; j++) {
                parkingLot.checkSlot(0, i, j);
            }
        }

        parkingLot.leave(car2);
        parkingLot.checkSlot(0, 0, 1);

        Car car9 = new Car("ZZZZ");
        parkingLot.park(car9);

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 6; j++) {
                parkingLot.checkSlot(0, i, j);
            }
        }
    }
}