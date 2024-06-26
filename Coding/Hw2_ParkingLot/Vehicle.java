
class Vehicle {
    private String license;
    private ParkingSpot parkingSpot;

    Vehicle(String license) {
        this.license = license;
        parkingSpot = null;
    }

    public void parkInSpot(ParkingSpot spot) {
        this.parkingSpot = spot;
    }

    public void unparkInSpot() {
        parkingSpot.unpark(this);
        this.parkingSpot = null;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}