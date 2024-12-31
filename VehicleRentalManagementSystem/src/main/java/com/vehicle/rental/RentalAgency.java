package com.vehicle.rental;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<Vehicle> fleet; // List of all vehicles in the agency
    private List<RentalTransaction> rentalHistory; // List of rental transactions

    // Constructor
    public RentalAgency() {
        this.fleet = new ArrayList<>();
        this.rentalHistory = new ArrayList<>();
    }
    public List<Vehicle> getFleet() {
        return fleet;
    }
    public void setFleet(List<Vehicle> fleet) {
        this.fleet = fleet;
    }
    public List<RentalTransaction> getRentalHistory() {
        return rentalHistory;
    }

    public void setRentalHistory(List<RentalTransaction> rentalHistory) {
        this.rentalHistory = rentalHistory;
    }

    // Add a vehicle to the fleet
    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
        System.out.println("Vehicle added: " + vehicle);
    }

    // Remove a vehicle from the fleet
    public void removeVehicle(String vehicleId) {
        fleet.removeIf(vehicle -> vehicle.getVehicleId().equals(vehicleId));
        System.out.println("Vehicle with ID " + vehicleId + " removed from fleet.");
    }

    // Retrieve all available vehicles
    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : fleet) {
            if (vehicle.isAvailableForRental()) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    // Rent a vehicle to a customer
    public void rentVehicle(String vehicleId, Customer customer, int days) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getVehicleId().equals(vehicleId) && vehicle.isAvailableForRental()) {
                double cost = vehicle.calculateRentalCost(days);
                RentalTransaction transaction = new RentalTransaction(vehicle,customer, days, cost);
                rentalHistory.add(transaction);

                // Update vehicle status (if needed)
                vehicle.setAvailable(false);

                System.out.println("Vehicle rented successfully!");
                System.out.println(transaction);
                return;
            }
        }
        System.out.println("Vehicle is not available or does not exist.");
    }

    // Return a rented vehicle
    public void returnVehicle(String vehicleId) {
        for (RentalTransaction transaction : rentalHistory) {
            if (transaction.getVehicle().getVehicleId().equals(vehicleId) && !transaction.getVehicle().isAvailableForRental()) {
                transaction.getVehicle().setAvailable(true);
                System.out.println("Vehicle with ID " + vehicleId + " returned successfully.");
                return;
            }
        }
        System.out.println("Vehicle with ID " + vehicleId + " not found in active rentals.");
    }

    // Generate a report of available vehicles
    public void generateAvailableVehiclesReport() {
        List<Vehicle> availableVehicles = getAvailableVehicles();
        System.out.println("Available Vehicles Report:");
        for (Vehicle vehicle : availableVehicles) {
            System.out.println(vehicle);
        }
    }

    // Generate rental transaction history
    public void generateRentalHistoryReport() {
        System.out.println("Rental History Report:");
        for (RentalTransaction transaction : rentalHistory) {
            System.out.println(transaction);
        }
    }

    public String findMostRentedVehicleModel() {

        return "";
    }

    public String calculateTotalRevenue() {
        return "";
    }
}
