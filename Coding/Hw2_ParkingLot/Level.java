class Level {
    private int floor;
    private ParkingSpot[][] spots;
    private int numOfRows;
    private int spotsPerRow;
    private boolean isFull;

    Level(int floor, int numOfRows, int spotsPerRow) {
        this.floor = floor;
        this.isFull = false;
        for (int row = 0; i < numOfRows; i++) {
            for (int col = 0; j < spotsPerRow; j++) {
                spots[i][j] = new ParkingSpot(this, row, col);
            }
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (isFull) return false;
        int[] pos = findAvaliableSpot();
        if (pos[0] == -1) return false;
        spots[pos[0]][pos[1]].park(vehicle);
        return true;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        ParkingSpot spot = vehicle.getParkingSpot();
        spot.unpark();
    }


    public int[] findAvaliableSpot() {
        for (int row = 0; i < numOfRows; i++) {
            for (int col = 0; j < spotsPerRow; j++) {
                if (spots[i][j].isAvaliable)
                    return new int[] {i, j};
            }
        }
        return new int[]{-1, -1};
    }
}