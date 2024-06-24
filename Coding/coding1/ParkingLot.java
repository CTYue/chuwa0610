
public class ParkingLot{
    private int lotNumber;
    private int floorNumber;
    private int lotSize;
    private Vehical parkedVehical;

    public void parkAVehical(Vehical v){
        if(parkedVehical == null) && fitInLot(v){
            setParkedVehical(v);
            v.setParkedInLot(this);
        }
    }

    public removingVehical(){
        if(!isVacent()){
            parkedVehical.setParkedInLot(null);
            setParkedVehical(null);
        }
    }

    public boolean isVacent(){
        return parkedVehical == null;
    }
    public boolean fitInLot(Vehical v){
        return v.size<=lotSize;
    }

    public Vehical getParkedVehical() {
        return parkedVehical;
    }

    public void setParkedVehical(Vehical parkedVehical) {
        this.parkedVehical = parkedVehical;
    }
}

abstract class Vehical {

    private int size;
    private String type;
    private String color;
    private ParkingLot parkedInLot;

    public isParked();

    public void setParkedInLot(ParkingLot parkedInLot) {
        this.parkedInLot = parkedInLot;
    }
}

class Car extends Vehical {

    public Car(){
        size = 2;
        type = "car"
    }

}

class Motorcycle extends Motorcycle {

    public Motorcycle(){
        size = 1;
        type = "motorcycle"
    }


}
