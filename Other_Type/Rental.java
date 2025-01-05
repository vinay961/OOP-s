package Other_Type;

import java.util.ArrayList;
import java.util.List;

class Vehicle {
    private String licensePlate;
    private String type;
    private int rentalPrice;

    public Vehicle(String licensePlate, String type, int rentalPrice) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.rentalPrice = rentalPrice;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getType() {
        return type;
    }

    public int getRentalPrice() {
        return rentalPrice;
    }

    @Override
    public String toString() {
        return type + " with license plate " + licensePlate + " available for " + rentalPrice + " per day.";
    }
}

class Agency {
    private List<Vehicle> availableVehicles;

    public Agency() {
        this.availableVehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle v) {
        availableVehicles.add(v);
        System.out.println("Vehicle " + v.getLicensePlate() + " added to the agency.");
    }

    public void removeVehicle(Vehicle v) {
        if (availableVehicles.remove(v)) {
            System.out.println("Vehicle " + v.getLicensePlate() + " has been rented.");
        } else {
            System.out.println("Vehicle not found in agency's inventory.");
        }
    }

    public Vehicle getVehicleByNumber(String number) {
        for (Vehicle vehicle : availableVehicles) {
            if (vehicle.getLicensePlate().equals(number)) {
                return vehicle;
            }
        }
        return null; 
    }

    public void displayAvailableVehicles() {
        if (availableVehicles.isEmpty()) {
            System.out.println("No vehicles available for rent.");
        } else {
            System.out.println("Available Vehicles:");
            for (Vehicle vehicle : availableVehicles) {
                System.out.println(vehicle); 
            }
        }
    }
}

class Customer {
    private String name;
    private List<Vehicle> rentedVehicles;

    public Customer(String name) {
        this.name = name;
        this.rentedVehicles = new ArrayList<>();
    }

    public void rentVehicle(String number, Agency agency) {
        Vehicle vehicle = agency.getVehicleByNumber(number);
        if (vehicle != null) {
            agency.removeVehicle(vehicle); 
            rentedVehicles.add(vehicle);  
            System.out.println(name + " rented the vehicle: " + vehicle.getLicensePlate());
        } else {
            System.out.println("Vehicle with license number " + number + " is not available.");
        }
    }

    public void returnVehicle(String number, Agency agency) {
        Vehicle vehicleToReturn = null;

        for (Vehicle vehicle : rentedVehicles) {
            if (vehicle.getLicensePlate().equals(number)) {
                vehicleToReturn = vehicle;
                break;
            }
        }

        if (vehicleToReturn != null) {
            rentedVehicles.remove(vehicleToReturn); 
            agency.addVehicle(vehicleToReturn);    
            System.out.println(name + " returned the vehicle: " + vehicleToReturn.getLicensePlate());
        } else {
            System.out.println(name + " did not rent a vehicle with license number " + number);
        }
    }

    public void displayRentedVehicles() {
        if (rentedVehicles.isEmpty()) {
            System.out.println(name + " has not rented any vehicles.");
        } else {
            System.out.println(name + "'s Rented Vehicles:");
            for (Vehicle vehicle : rentedVehicles) {
                System.out.println(vehicle); 
            }
        }
    }
}

public class Rental {
    public static void main(String[] args) {
        // Create agency and add vehicles
        Agency agency = new Agency();
        agency.addVehicle(new Vehicle("UP12AC1000", "Car", 2499));
        agency.addVehicle(new Vehicle("UP12AC0100", "Car", 4999));
        agency.addVehicle(new Vehicle("UP26WA2121", "Bike", 1200));
        agency.addVehicle(new Vehicle("HR26BC0100", "Bike", 4500));

        // Create customer
        Customer cust = new Customer("Vinay");

        // Customer rents vehicles
        cust.rentVehicle("UP12AC0100", agency); 
        cust.rentVehicle("UP26WA2121", agency); 
        cust.rentVehicle("UP12AC9999", agency); 

        // Display remaining vehicles in the agency
        System.out.println("\n.............Vehicles in stock.............");
        agency.displayAvailableVehicles();

        // Display customer's rented vehicles
        System.out.println("\n.............Vinay's rented vehicles.............");
        cust.displayRentedVehicles();

        // Customer returns a vehicle
        cust.returnVehicle("UP26WA2121", agency); 
        cust.returnVehicle("UP12AC9999", agency); 

        // Display updated vehicle inventories
        System.out.println("\n.............Updated Vehicles in stock.............");
        agency.displayAvailableVehicles();
        System.out.println("\n.............Updated Vinay's rented vehicles.............");
        cust.displayRentedVehicles();
    }
}
