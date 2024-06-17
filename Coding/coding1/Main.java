package coding1;

/**
 * description: main
 * date: 6/17/24 4:07 PM
 * author: jinhao_pang
 * version: 1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParkingArea A = new ParkingArea("A", 50); // initialize a parking region A with 50 capacity
        ParkingArea B = new ParkingArea("B", 150); // initialize a parking region B with 150 capacity
        ParkingLot.addParkingArea(A); // add the parking are to parking lot.
        ParkingLot.addParkingArea(B); // add the parking are to parking lot.
        System.out.println("The total capacity of the parking lot is "+ ParkingLot.getCapacity());
        System.out.println("==================================================");

        // now let's add a car to region B
        B.addCar("TL20222");
        System.out.println("The remaining capacity of the parking region B is "+ B.getAvailableSlots());

        System.out.println("The remaining capacity of the parking lot is "+ ParkingLot.getAvailableSlots());
        System.out.println("==================================================");
        // if this car leaves after 3 hours, we make it 3 second to simulate 3 hours. Each hour charges 2 dollars.
        Thread.sleep(3000);
        int fee = B.carLeave("TL20222");
        System.out.println("After leaving, The remaining capacity of the parking region B is "+ B.getAvailableSlots());
        System.out.println("After leaving, The remaining capacity of the parking Lot is "+ ParkingLot.getAvailableSlots());

        System.out.println("The fee is "+ fee);

    }
}
