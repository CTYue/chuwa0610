
class ParkingLot {
    private String name;
    private String address;
    private int numOfLevels;
    private Level[] levels;

    ParkingLot(int n, int numOfRows, int spotsPerRow) {
        this.numOfLevels = n;
        levels = new Level[n];
        for (int i = 0; i < n; i++) {
            levels[i] = new Level(i, numOfRows, spotsPerRow);
        }
    }

    public boolean park(Vehicle vehicle) {
        for (int i = 0; i < nunmOfLevels; i++) {
            if (levels[i].parkVehicle(vehicle)) return true;
        }
        return false;
    }

    public boolean unPark(Vehicle vehicle) {
        vehicle.unparkInSpot();
    }


}


