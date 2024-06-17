package org.parkinglot;

public class Vehicle {
    private String licensePlate;
    private String model;

    private boolean handicapped;

    public Vehicle(String licensePlate, String model, boolean handicapped) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.handicapped = handicapped;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isHandicapped() {
        return handicapped;
    }

    public void setHandicapped(boolean handicapped) {
        this.handicapped = handicapped;
    }
}
