public abstract class Vehicle{
    private String licensePlate;
    private String vehicleType;
    private long entryTime;
    public Vehicle(String licensePlate, String vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }
    public String getLicensePlate() {
        return licensePlate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public long getEntryTime() {
        return entryTime;
    }
    public abstract double calculateParkingFee();
}
public class Car extends Vehicle{
    public Car(String licensePlate) {
        super(licensePlate, "Car");
    }
    @Override
    public double calculateParkingFee() {
        return 2.0;
    }
}
public class Motorbike extends Vehicle{
    public Motorbike(String licensePlate) {
        super(licensePlate, "Motorbike");
    }
    @Override
    public double calculateParkingFee() {
        return 1.0;
    }
}
public class ParkingSpot{
    private int spotNumber;
    private boolean isOccupied;
    private String vehicleType;
    public ParkingSpot(int spotNumber, String vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }
    public int getSpotNumber() {
        return spotNumber;
    }
    public boolean isOccupied() {
        return isOccupied;
    }
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
    public String getVehicleType() {
        return vehicleType;
    }

}
public class ParkingLot {
    private int totalSpots;
    private int availableSpots;
    private ParkingSpot[] parkingSpots;

    public ParkingLot(int totalSpots) {
        this.totalSpots = totalSpots;
        this.availableSpots = totalSpots;
        this.parkingSpots = new ParkingSpot[totalSpots];
        for (int i = 0; i < totalSpots; i++) {
            parkingSpots[i] = new ParkingSpot(i + 1, null);
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (availableSpots == 0) {
            System.out.println("Parking lot is full");
            return false;
        }
        for (int i = 0; i < totalSpots; i++) {
            if (!parkingSpots[i].isOccupied()) {
                parkingSpots[i].setOccupied(true);
                parkingSpots[i].setVehicleType(vehicle.getVehicleType());
                vehicle.setEntryTime(System.currentTimeMillis());
                availableSpots--;
                System.out.println("Vehicle parked at spot number: " + parkingSpots[i].getSpotNumber());
                return true;
            }
        }
        return false;
    }
}

