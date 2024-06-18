package org.example;

public class Slot {
    private boolean isOccupied;
    private Vehicle occupiedVeh;
    private int levelNo;

    public Slot(int levelNo){
        this.levelNo  = levelNo;
        this.isOccupied = false;
    }

    public boolean getIsOccupied(){
        return isOccupied;
    }

    public Vehicle getOccupiedVeh() {
        return occupiedVeh;
    }

    public void empty(){
        isOccupied = false;
        occupiedVeh = null;
    }

    public void park(Vehicle vehicle) {
        occupiedVeh = vehicle;
        isOccupied = true;
    }

    public int getLevelNo() {
        return levelNo;
    }
}
