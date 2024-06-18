public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(5);
        Vehicle car = new Car("asdfgh");
        Vehicle bike = new Bike("zxcvb");
        System.out.println("Parking car: " + parkingLot.parkVehicle(car));
        System.out.println("Parking bike: " + parkingLot.parkVehicle(bike));
        parkingLot.printAllLicensePlates();
        parkingLot.leaveSpot(0);
        System.out.println("Car left the spot: " + parkingLot.leaveSpot(0));
        parkingLot.printAllLicensePlates();

    }
}
