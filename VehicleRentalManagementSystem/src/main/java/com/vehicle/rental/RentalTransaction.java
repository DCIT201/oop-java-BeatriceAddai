// Create a rental transaction
package com.vehicle.rental;

public class RentalTransaction {
    private final Vehicle vehicle;
    private final Customer customer;
    private final int days;
    private final double totalCost;

    // Constructor
    public RentalTransaction(Vehicle vehicle, Customer customer, int days, double totalCost) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
        this.totalCost = totalCost;
    }

    // Getters
    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return "RentalTransaction{" +
                "vehicle=" + vehicle +
                ", customer=" + customer.getName() +
                ", days=" + days +
                ", cost=" + totalCost +
                '}';
    }
}