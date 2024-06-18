package org.example;

public class Level {
    private final int col;
    private final int row;
    private final int no;
    private int availableNum;
    private Slot[][] slots;

    public Level(int no, int row, int col) {
        this.no = no;
        this.row = row;
        this.col = col;
        this.availableNum = row * col;
        slots = new Slot[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++) {
                slots[i][j] = new Slot(no);
            }
        }
    }

    public boolean isAvailable(Vehicle vehicle){
        if(vehicle.getSize() == 1){
            return availableNum >= 1;
        }
        // vehicle needs two empty slots in the same row
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col - 1; j++) {
                if(!slots[i][j].getIsOccupied() && !slots[i][j + 1].getIsOccupied()) return true;
            }
        }
        return false;
    }

    public int[] park(Vehicle vehicle) {
        int[] position;
        if(vehicle.getSize() == 1){
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    if(!slots[i][j].getIsOccupied()){
                        slots[i][j].park(vehicle);
                        vehicle.setSlot(slots[i][j]);
                        availableNum--;
                        return new int[]{i, j};
                    }
                }
            }
        }else{
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col - 1; j++) {
                    if(!slots[i][j].getIsOccupied() && !slots[i][j + 1].getIsOccupied()){
                        slots[i][j].park(vehicle);
                        slots[i][j + 1].park(vehicle);
                        vehicle.setSlot(slots[i][j], slots[i][j + 1]);
                        availableNum -= 2;
                        return new int[]{i, j};
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int getNo() {
        return no;
    }

    public void getSlotInfo(int row, int col){
        if (row > this.row || col > this.col || row < 0 || col < 0) {
            System.out.println("Invalid row/col!");
        }
        if(slots[row][col] == null || !slots[row][col].getIsOccupied()){
            System.out.println("Slot empty");
            return;
        }
        System.out.println("Slot in level " + getNo() + " (" + row + ", " + col + ") is occupied by vehicle:");
        System.out.println(slots[row][col].getOccupiedVeh().getPlate());
    }

    public void addAvailableNum(int n) {
        this.availableNum += n;
    }
}
