public class ParkingSpot {
    private int spotID;
    private Vehicle vehicle;
    public ParkingSpot(int spotID) {
        this.spotID = spotID;
    }
    public boolean isAvailable() {
        return this.vehicle == null;
    }
    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public void leave() {
        this.vehicle = null;
    }
    public Vehicle getVehicle() {
        return this.vehicle;
    }
    public int getSpotID() {
        return this.spotID;
    }


}
