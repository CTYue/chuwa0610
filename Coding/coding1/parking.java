import java.util.ArrayList;
import java.util.List;

// Enum to define type of vehicles
enum VehicleType {
    CAR, MOTORCYCLE;
}

// Vehicle base class
abstract class Vehicle {
    protected String licensePlate;
    protected VehicleType type;

    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}

// Specific vehicle types
class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        super(licensePlate, VehicleType.MOTORCYCLE);
    }
}

// Parking Spot
class ParkingSpot {
    private Vehicle vehicle;
    private final VehicleType type;
    private final int spotNumber;

    public ParkingSpot(VehicleType type, int spotNumber) {
        this.type = type;
        this.spotNumber = spotNumber;
    }

    boolean park(Vehicle vehicle) {
        if (this.vehicle == null && vehicle.getType() == this.type) {
            this.vehicle = vehicle;
            System.out.println("Vehicle parked at spot " + this.spotNumber);
            return true;
        }
        return false;
    }

    void leave() {
        System.out.println("Vehicle left from spot " + this.spot37Number);
        this.vehicle = null;
    }

    public boolean isAvailable() {
        return this.vehicle == null;
    }
}

// Parking Floor
class ParkingFloor {
    private List<ParkingSpot> spots;

    public ParkingFloor(int numSpots) {
        spots = new ArrayList<>();
        // Example initialization logic
        for (int i = 0; i < numSpots; i++) {
            VehicleType type = (i % 2 == 0) ? VehicleType.CAR : VehicleType.MOTORCYCLE;
            spots.add(new ParkingSpot(type, i + 1));
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.park(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void leaveVehicle(int spotNumber) {
        if (spotNumber < 1 || spotNumber > spots.size()) {
            System.out.println("Invalid spot number");
            return;
        }
        spots.get(spotNumber - 1).leave();
    }
}

// Parking Lot
public class ParkingLot {
    private List<ParkingFloor> floors;

    public ParkingLot(int numFloors, int spotsPerFloor) {
        floors = new ArrayList<>();
        for (int i = 0; i < numFloors; i++) {
            floors.add(new ParkingFloor(spotsPerFloor));
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            if (floor.parkVehicle(vehicle)) {
                return true;
            }
        }
        System.out.println("Failed to park the vehicle. No spots available.");
        return false;
    }

    public void leaveVehicle(int floorNumber, int spotNumber) {
        if (floorNumber < 1 || floorNumber > floors.size()) {
            System.out.println("Invalid floor number");
            return;
        }
        floors.get(floorNumber - 1).leaveVehicle(spotNumber);
    }
}