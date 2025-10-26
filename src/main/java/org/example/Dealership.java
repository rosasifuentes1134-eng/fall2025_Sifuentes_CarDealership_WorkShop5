package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Vehicle> inventory;

    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inventory = new ArrayList<>();
    }
    public Dealership(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(List<Vehicle> inventory) {
        this.inventory = inventory;
    }

    public List<Vehicle> getVehicleByPrice(double min, double max) {
        List<Vehicle> vehicles = new ArrayList<>();

        for (Vehicle vehicle: inventory){
            if(vehicle.getPrice()>= min && vehicle.getPrice()<= max){
                vehicles.add(vehicle);
            }
        }
        return vehicles;

    }
    public List<Vehicle> getVehicleMakeModel(String make,String model){
        List<Vehicle> vehicles = new ArrayList<>();

        for (Vehicle vehicle:inventory){
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehicleByYear(double min, double max){
        List<Vehicle> vehicles = new ArrayList<>();

        for (Vehicle vehicle: inventory){
            if (vehicle.getYear() >= min && vehicle.getYear() <= max){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }
    public List<Vehicle> getVehicleColor(String color){
        List<Vehicle>vehicles = new ArrayList<>();

        for (Vehicle vehicle: inventory){
            if (vehicle.getColor().equalsIgnoreCase(color)){
                vehicles.add(vehicle);
            }

        }
        return vehicles;
    }
    public List<Vehicle> getVehicleMileage(double min, double max){
        List<Vehicle> vehicles = new ArrayList<>();

        for (Vehicle vehicle: inventory){
            if (vehicle.getOdometer()>= min && vehicle.getOdometer()<= max){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }
    public List<Vehicle> getVehicleByType(String vehicleType){
        List<Vehicle>vehicles = new ArrayList<>();

        for (Vehicle vehicle: inventory){
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }
    public List<Vehicle> getAllVehicles(){
      return inventory;
    }
    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);

    }
    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);

    }
}
