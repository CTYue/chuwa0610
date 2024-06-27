package Pattern.Builder;

public class OfoBuilder extends Builder {

    public void buildFrame(){
        bike.setFrame("铝合金");
    }
    public void buildSeat(){
        bike.setSeat("真皮");
    }
    public Bike CreateBike(){
        return bike;
    }



}
