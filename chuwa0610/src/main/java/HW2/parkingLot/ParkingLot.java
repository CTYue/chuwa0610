package HW2.parkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingSpot> spots;
    private int capacity;
    private int availableSpots;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.availableSpots = capacity;
        spots = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            spots.add(new ParkingSpot(i));
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                spot.park(vehicle);
                availableSpots--;
                return true;
            }
        }
        return false;
    }

    public boolean leaveVehicle(int spotNumber) {
        if (spotNumber < 0 || spotNumber >= capacity) {
            return false;
        }
        ParkingSpot spot = spots.get(spotNumber);
        if (!spot.isAvailable()) {
            spot.leave();
            availableSpots++;
            return true;
        }
        return false;
    }

    public int getAvailableSpots() {
        return availableSpots;
    }
}
