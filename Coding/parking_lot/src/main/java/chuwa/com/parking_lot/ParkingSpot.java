package chuwa.com.parking_lot;
import chuwa.com.parking_lot.Vehicle;

public class ParkingSpot {
    private Vehicle.VehicleSize size;
    private Vehicle currentVehicle;

    public ParkingSpot(Vehicle.VehicleSize size) {
        this.size = size;
    }

    public Vehicle.VehicleSize getSize() {
        return size;
    }

    public boolean isAvailable() {
        return currentVehicle == null;
    }

    public boolean park(Vehicle vehicle) {
        if (isAvailable() && vehicle.canFitInSpot(this)) {
            currentVehicle = vehicle;
            return true;
        }
        return false;
    }

    public void leave() {
        currentVehicle = null;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }
}
