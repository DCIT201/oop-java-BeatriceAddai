package com.vehicle.rental;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        //  Create a RentalAgency
        RentalAgency rentalAgency = new RentalAgency();

        //  Add Vehicles to the Fleet
        Vehicle car1 = new Car(UUID.randomUUID().toString(), "Toyota Camry", 50.0, true);
        Vehicle car2 = new Car(UUID.randomUUID().toString(), "Honda Civic", 50.0, false);
        Vehicle motorcycle1 = new Motorcycle ( "MOTO001","Yamaha MT-15",20.0, true);
        Vehicle truck = new Truck ("TRUCK001", "Ford F-150", 100.0, 500);
        rentalAgency.addVehicle(car1);
        rentalAgency.addVehicle(car2);
        rentalAgency.addVehicle(motorcycle1);
        rentalAgency.addVehicle(truck);

        //  Create Customers
        Customer customer1 = new Customer("CUSTOMER001","Alice");
        Customer customer2 = new Customer("CUSTOMER002","Bob");

        //  Display Available Vehicles
        System.out.println("\n--- Available Vehicles ---");
        rentalAgency.generateAvailableVehiclesReport();

        //  Rent Vehicles
        System.out.println("\n--- Renting Vehicles ---");
        rentalAgency.rentVehicle(car1.getVehicleId(), customer1, 5); // Rent car1 to Alice for 5 days
        rentalAgency.rentVehicle(motorcycle1.getVehicleId(), customer2, 3); // Rent motorcycle1 to Bob for 3 days

        //  Display Updated Available Vehicles
        System.out.println("\n--- Updated Available Vehicles ---");
        rentalAgency.generateAvailableVehiclesReport();

        //  Return a Vehicle
        System.out.println("\n--- Returning a Vehicle ---");
        rentalAgency.returnVehicle(car1.getVehicleId()); // Alice returns car1

        //  Generate Rental History Report
        System.out.println("\n--- Rental History Report ---");
        rentalAgency.generateRentalHistoryReport();

        // Attempt to Rent an Unavailable Vehicle
        System.out.println("\n--- Attempting to Rent an Unavailable Vehicle ---");
        rentalAgency.rentVehicle(car2.getVehicleId(), customer2, 2);

        //  Generate Final Report of Available Vehicles
        System.out.println("\n--- Final Available Vehicles ---");
        rentalAgency.generateAvailableVehiclesReport();
    }
}