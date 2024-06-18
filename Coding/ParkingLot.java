package org.example;

import java.util.List;

public class ParkingLot {
    private String address;
    private Level[] levels;
    private int availableNum;
    private int totalNum;

    public ParkingLot(int levelNum, int row, int col, String address){
        if(levelNum < 0 || row < 0 || col < 0) return;
        this.address = address;
        this.levels = new Level[levelNum];
        for(int i = 0; i < levelNum; i++){
            levels[i] = new Level(i, row, col);
        }
        this.totalNum = levelNum * row * col;
        this.availableNum = totalNum;
    }

    public String getAddress() {
        return address;
    }

    public boolean checkAvailable(Vehicle vehicle) {
        if(vehicle.getSize() == 1){
            return availableNum >= 1;
        }else {
            for (Level level : levels) {
                if (level.isAvailable(vehicle)) return true;
            }
            return false;
        }
    }

    public int closestAvailableLevel(Vehicle vehicle) {
        if (!checkAvailable(vehicle)) return -1;
        for(Level level : levels){
            if(level.isAvailable(vehicle)){
                return level.getNo();
            }
        }
        return -1;
    }

    public void park(Vehicle vehicle) {
        if (!checkAvailable(vehicle)) return;
        int levelNo = closestAvailableLevel(vehicle);
        int[] position = levels[levelNo].park(vehicle);
        availableNum--;
        System.out.println("Vehicle parked at:");
        System.out.println("Level: " + levelNo);
        System.out.println("Slot: " + position[0] + ", " + position[1]);
        System.out.println("Slots taken: " + vehicle.getSize());
    }

    public void leave(Vehicle vehicle){
        List<Slot> slotList = vehicle.getSlot();
        for(Slot slot : slotList){
            slot.empty();
            levels[slot.getLevelNo()].addAvailableNum(1);
            availableNum++;
        }
        vehicle.leave();
    }

    public void checkSlot(int levelNo, int row, int col) {
        levels[levelNo].getSlotInfo(row, col);
    }
}
