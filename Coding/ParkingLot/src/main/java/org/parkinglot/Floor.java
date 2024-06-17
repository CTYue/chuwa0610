package org.parkinglot;

public class Floor {
    private int floorNum;
    private int normal;
    private int handicapped;
    private int electric;
    private boolean[] normalSpot;
    private boolean[] handicappedSpot;
    private boolean[] electricSpot;

    public Floor(int floorNum, int normal, int handicapped, int electric){
        this.floorNum = floorNum;
        this.normal = normal;
        this.handicapped = handicapped;
        this.electric = electric;
        this.normalSpot = new boolean[normal];
        this.handicappedSpot = new boolean[handicapped];
        this.electricSpot = new boolean[electric];
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    public int getNormal() {
        return normal;
    }

    public void setNormal(int normal) {
        this.normal = normal;
        this.normalSpot = new boolean[normal];
    }

    public int getHandicapped() {
        return handicapped;
    }

    public void setHandicapped(int handicapped) {
        this.handicapped = handicapped;
        this.handicappedSpot = new boolean[handicapped];
    }

    public int getElectric() {
        return electric;
    }

    public void setElectric(int electric) {
        this.electric = electric;
        this.electricSpot = new boolean[electric];
    }

    public boolean[] getNormalSpot() {
        return normalSpot;
    }

    public boolean[] getHandicappedSpot() {
        return handicappedSpot;
    }


    public boolean[] getElectricSpot() {
        return electricSpot;
    }

    public void parkNormal(int spot){
        if(spot >= this.normal){
            return;
        } else {
            this.normalSpot[spot] = true;
        }
    }

    public void leaveNormal(int spot){
        if(spot >= this.normal){
            return;
        } else {
            this.normalSpot[spot] = false;
        }
    }

    public void parkHandicapped(int spot){
        if(spot >= this.handicapped){
            return;
        } else {
            this.handicappedSpot[spot] = true;
        }
    }

    public void leaveHandicapped(int spot){
        if(spot >= this.handicapped){
            return;
        } else {
            this.handicappedSpot[spot] = false;
        }
    }

    public void parkElectric(int spot){
        if(spot >= this.electric){
            return;
        } else {
            this.electricSpot[spot] = true;
        }
    }

    public void leaveElectric(int spot){
        if(spot >= this.electric){
            return;
        } else {
            this.electricSpot[spot] = false;
        }
    }
}
