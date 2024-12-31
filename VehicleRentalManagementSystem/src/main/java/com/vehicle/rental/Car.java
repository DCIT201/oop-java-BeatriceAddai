package com.vehicle.rental;

public class Car extends Vehicle {
    private boolean hasGPS;

    public Car(String vehicleId, String model, double baseRentalRate, boolean hasGPS) {
        super(vehicleId, model, baseRentalRate);
        this.hasGPS = hasGPS;
    }

    public boolean hasGPS() {
        return hasGPS;
    }

    public void setHasGPS(boolean hasGPS) {
        this.hasGPS = hasGPS;
    }

    @Override
    public double calculateRentalCost(int days) {
        double cost = getBaseRentalRate() * days;
        boolean hasHelmet = false;
        if (hasHelmet) cost += 5 * days; // Additional charge for helmet
        return cost;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable(); // Check availability from the parent class
    }

    @Override
    public void returnVehicle() {

    }

    // Overriding toString
    @Override
    public String toString() {
        return "Car{" +
                "vehicleId='" + getVehicleId() + '\'' +
                ", model='" + getModel() + '\'' +
                ", baseRentalRate=" + getBaseRentalRate() +
                ", hasGPS=" + hasGPS +
                ", isAvailable=" + isAvailable() +
                '}';
    }
}



