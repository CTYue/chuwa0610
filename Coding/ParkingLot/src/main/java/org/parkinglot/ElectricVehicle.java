package org.parkinglot;

public class ElectricVehicle extends Vehicle{
    private String licensePlate;
    private String model;
    private boolean handicapped;

    private int batteryPercentage;
    public ElectricVehicle(String licensePlate, String model, boolean handicapped, int batteryPercentage) {
        super(licensePlate, model, handicapped);
        this.batteryPercentage = batteryPercentage;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean isHandicapped() {
        return handicapped;
    }

    @Override
    public void setHandicapped(boolean handicapped) {
        this.handicapped = handicapped;
    }

    public int getBatteryPercentage() {
        return batteryPercentage;
    }

    public void setBatteryPercentage(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    public void charge(){
        this.batteryPercentage = 100;
    }
}
