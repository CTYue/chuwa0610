import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingSpot> spots;
    public ParkingLot(int numSpots){
        spots = new ArrayList<>(numSpots);
        for(int i=0;i<numSpots;i++){
            spots.add(new ParkingSpot(i));
        }
    }
    public boolean parkVehicle(Vehicle  vehicle){
        for(ParkingSpot spot:spots){
            if(spot.isAvailable()){
                spot.park(vehicle);
                return true;
            }
        }
        return false;
    }
    public boolean leaveSpot(int spotId) {
        if (spotId >= 0 && spotId < spots.size()) {
            spots.get(spotId).leave();
            return true;
        }
        return false;
    }

    public void printAllLicensePlates(){
        System.out.println("Vehicles currently parked:");
        for(ParkingSpot spot:spots){
            if(!spot.isAvailable()){
                System.out.println("Spot " + spot.getSpotID() + "Parking : " +spot.getVehicle().getLicensePlate());
            }
        }
    }

}
