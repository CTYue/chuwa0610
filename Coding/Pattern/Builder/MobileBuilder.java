package Pattern.Builder;

public class MobileBuilder extends Builder {
    public void buildFrame(){
        bike.setFrame("碳纤维");
    }
    public void buildSeat(){
        bike.setSeat("木头");
    }
    public Bike CreateBike(){
        return bike;
    }

}
