class ParkingSpot {
    private int row;
    private int col;
    boolean isAvalibale;
    private Level level;
    private Vehicle vehicle;

    ParkingSpot(Level level, int row, int col,) {
        this.level = level;
        this.row = row;
        this.col = col;
        this.isAvalibale = true;
    }

    public boolean park(Vehicle v) {
        this.vehicle = v;
        this.isAvalibale = false;
        vehicle.parkInSpot(this);
        return true;
    }

    public boolean unpark(Vehicle vehicle) {
        isAvalibale = true;
        vehicle = null;
    }
}