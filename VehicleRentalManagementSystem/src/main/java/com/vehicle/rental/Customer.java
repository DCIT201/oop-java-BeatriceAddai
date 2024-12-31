package com.vehicle.rental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private List<RentalTransaction> rentalHistory; // Stores past rentals
    private RentalTransaction currentRental;       // Tracks ongoing rental

    public Customer(String customerId, String name) {
        if (customerId == null || customerId.isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty.");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.customerId = customerId;
        this.name = name;
        this.rentalHistory = new ArrayList<>();
        this.currentRental = null; // No ongoing rentals initially
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public List<RentalTransaction> getRentalHistory() {
        return rentalHistory;
    }

    public RentalTransaction getCurrentRental() {
        return currentRental;
    }

    // Adds a rental to the customer's rental history
    public void addRentalToHistory(RentalTransaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction cannot be null.");
        }
        rentalHistory.add(transaction);
    }

    // Starts a rental for the customer
    public boolean rentVehicle(Vehicle vehicle, int days) {
        if (!isEligibleToRent()) {
            System.out.println("Customer " + name + " is not eligible to rent another vehicle.");
            return false;
        }
        if (!vehicle.isAvailable()) {
            System.out.println("Vehicle " + vehicle.getModel() + " is not available for rent.");
            return false;
        }

        // Create a new rental transaction
        double cost = vehicle.calculateRentalCost(days);
        RentalTransaction transaction = new RentalTransaction(vehicle, this, days, cost);
        currentRental = transaction;

        // Update the vehicle's availability
        vehicle.setAvailable(false);

        System.out.println("Customer " + name + " successfully rented " + vehicle.getModel() + " for " + days + " days.");
        return true;
    }

    // Ends the current rental and adds it to the history
    public void returnCurrentRental() {
        if (currentRental == null) {
            System.out.println("Customer " + name + " has no active rentals to return.");
            return;
        }

        // Mark the vehicle as available
        currentRental.getVehicle().setAvailable(true);

        // Add the current rental to history and clear active rental
        addRentalToHistory(currentRental);
        currentRental = null;

        System.out.println("Customer " + name + " successfully returned the vehicle.");
    }

    // Checks if the customer is eligible to rent
    public boolean isEligibleToRent() {
        // A customer cannot rent another vehicle while having an active rental
        return currentRental == null;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", rentalHistorySize=" + rentalHistory.size() +
                ", hasActiveRental=" + (currentRental != null) +
                '}';
    }
}




