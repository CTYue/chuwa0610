package org.example;

import java.util.ArrayList;
import java.util.List;

public class Truck implements Vehicle{
    private int size = 2;
    private String plate;

    private Slot[] slots;

    public Truck(String plate){
        this.plate = plate;
    }

    @Override
    public void setSlot(Slot... slot) {
        this.slots = new Slot[2];
        this.slots[0] = slot[0];
        this.slots[1] = slot[1];
    }

    public List<Slot> getSlot() {
        List<Slot> list = new ArrayList<>();
        list.add(slots[0]);
        list.add(slots[1]);
        return list;
    }
    public void leave(){
        this.slots = null;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getPlate() {
        return plate;
    }
}
