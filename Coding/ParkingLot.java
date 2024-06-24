package Coding;

class ParkingLot {
    private int capacity;
    private int availableSpaces;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.availableSpaces = capacity;
    }

    public boolean park() {
        if (availableSpaces > 0) {
            availableSpaces--;
            return true;
        } else {
            return false;
        }
    }

    public void leave() {
        if (availableSpaces < capacity) {
            availableSpaces++;
        }
    }

    public int getAvailableSpaces() {
        return availableSpaces;
    }

    public int getCapacity() {
        return capacity;
    }
}