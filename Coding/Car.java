package org.example;

import java.util.ArrayList;
import java.util.List;

public class Car implements Vehicle{
    private int size = 1;
    private String plate;

    private Slot slot;


    public Car(String plate){
        this.plate = plate;
    }

    @Override
    public void setSlot(Slot... slot) {
        this.slot = slot[0];
    }

    public List<Slot> getSlot() {
        List<Slot> list = new ArrayList<>();
        list.add(slot);
        return list;
    }

    public void leave(){
        this.slot = null;
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
