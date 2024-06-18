package org.example;

import java.util.List;

public interface Vehicle {

    public int getSize();
    public String getPlate();
    public void setSlot(Slot... slot);
    public List<Slot> getSlot();
    public void leave();

}
