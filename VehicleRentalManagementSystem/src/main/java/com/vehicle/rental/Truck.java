package com.vehicle.rental;

public class Truck extends Vehicle {
    private double cargoCapacity; // in kilograms

    public Truck(String vehicleId, String model, double baseRentalRate, double cargoCapacity) {
        super(vehicleId, model, baseRentalRate);
        if (cargoCapacity <= 0) {
            throw new IllegalArgumentException("Cargo capacity must be greater than zero");
        }
        this.cargoCapacity = cargoCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(double cargoCapacity) {
        if (cargoCapacity <= 0) {
            throw new IllegalArgumentException("Cargo capacity must be greater than zero");
        }
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        double cost = getBaseRentalRate() * days;
        if (cargoCapacity > 1000) {
            cost += 15 * days; // Additional charge for larger trucks
        }
        return cost;
    }

    @Override
    public boolean isAvailableForRental() {
        return false;
    }


    @Override
    public void returnVehicle() {
        if (isAvailable()) {
            System.out.println("Truck is already available.");
            return;
        }
        setAvailable(true);
        System.out.println("Truck returned successfully.");
    }

    @Override
    public String toString() {
        return "Truck{" +
                "vehicleId='" + getVehicleId() + '\'' +
                ", model='" + getModel() + '\'' +
                ", baseRentalRate=" + getBaseRentalRate() +
                ", cargoCapacity=" + cargoCapacity +
                ", isAvailable=" + isAvailable() +
                '}';
    }
}
