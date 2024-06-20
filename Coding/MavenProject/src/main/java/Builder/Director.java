package Builder;

public class Director {

    private final Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Bike constructor(){
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }
}
