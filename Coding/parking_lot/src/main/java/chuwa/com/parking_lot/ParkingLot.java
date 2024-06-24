package chuwa.com.parking_lot;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingSpot> spots;
    private int numberOfSpots;

    public ParkingLot(int numberOfSpots) {
        this.numberOfSpots = numberOfSpots;
        spots = new ArrayList<>(numberOfSpots);

        // Initialize parking spots
        for (int i = 0; i < numberOfSpots; i++) {
            if (i < numberOfSpots / 3) {
                spots.add(new ParkingSpot(Vehicle.VehicleSize.MOTORCYCLE));
            } else if (i < 2 * numberOfSpots / 3) {
                spots.add(new ParkingSpot(Vehicle.VehicleSize.COMPACT));
            } else {
                spots.add(new ParkingSpot(Vehicle.VehicleSize.LARGE));
            }
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.park(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void leaveSpot(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.getCurrentVehicle() != null && spot.getCurrentVehicle().getLicensePlate().equals(vehicle.getLicensePlate())) {
                spot.leave();
                return;
            }
        }
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public void displayParkingLot() {
        for (int i = 0; i < spots.size(); i++) {
            ParkingSpot spot = spots.get(i);
            String spotInfo = "Spot " + (i + 1) + ": ";
            if (spot.isAvailable()) {
                spotInfo += "Available (" + spot.getSize() + ")";
            } else {
                spotInfo += "Occupied by " + spot.getCurrentVehicle().getLicensePlate() + " (" + spot.getSize() + ")";
            }
            System.out.println(spotInfo);
        }
    }
}
