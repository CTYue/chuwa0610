package chuwa.com.parking_lot;


public class Vehicle {
    protected VehicleSize size;
    protected String licensePlate;

    public Vehicle(VehicleSize size, String licensePlate) {
        this.size = size;
        this.licensePlate = licensePlate;
    }

    public VehicleSize getSize() {
        return size;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize().ordinal() >= this.size.ordinal();
    };

    public enum VehicleSize {
        MOTORCYCLE, COMPACT, LARGE
    }
}