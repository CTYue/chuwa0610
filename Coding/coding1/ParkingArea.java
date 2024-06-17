package coding1;

import java.util.HashMap;

/**
 * description: ParkingArea
 * date: 6/17/24 3:56 PM
 * author: jinhao_pang
 * version: 1.0
 */
public class ParkingArea {
    public final String areaCode;
    private final int capacity; // capacity of parking area
    private int numTotalCar; // number of total cars
    private int availableSlots; // number of remaining parking slots.
    private static HashMap<String, Long> carTimeSlots = new HashMap<>();

    public ParkingArea(String areaCode, int capacity) {
        this.areaCode = areaCode;
        this.capacity = capacity;
        this.numTotalCar = 0;
        this.availableSlots = capacity;
    }

    public boolean addCar(String carCode){
        if (availableSlots>0){
            carTimeSlots.put(carCode, System.currentTimeMillis());
            availableSlots--;
            numTotalCar++;
            ParkingLot.addCar();
            return true;
        }
        return false;
    }

    public int carLeave(String carCode){
        ParkingLot.removeCar();
        availableSlots++;
        numTotalCar--;
        Long carEnterTime = carTimeSlots.get(carCode);
        return (int) ((System.currentTimeMillis()-carEnterTime)/1000*2);
    }


    public String getAreaCode() {
        return areaCode;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getNumTotalCar() {
        return numTotalCar;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }
}
