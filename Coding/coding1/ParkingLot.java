package coding1;

import java.util.HashMap;
import java.util.Map;

/**
 * description: ParkingLot
 * date: 6/17/24 3:52PM
 * author: jinhao_pang
 * version: 1.0
 */
public class ParkingLot {
    private static int capacity = 0; // capacity of parking lot
    private static int numTotalCar = 0; // number of total cars
    private static int availableSlots = 0; // number of remaining parking slots.
    private static final Map<String, ParkingArea> parkingAreaMap = new HashMap<>();

    public static void addParkingArea(ParkingArea parkingArea) {
        parkingAreaMap.put(parkingArea.getAreaCode(), parkingArea);
        capacity += parkingArea.getCapacity();
        numTotalCar += parkingArea.getNumTotalCar();
        availableSlots += parkingArea.getAvailableSlots();
    }

    public static void addCar() {
        numTotalCar++;
        availableSlots--;
    }
    public static boolean removeCar() {
        numTotalCar--;
        availableSlots++;
        return true;
    }


    public static int getCapacity() {
        return capacity;
    }

    public static int getNumTotalCar() {
        return numTotalCar;
    }

    public static int getAvailableSlots() {
        return availableSlots;
    }
}
