package org.example.contract;

import org.example.Vehicle;

public abstract class Contract {
    private String DateOfContract;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicle;


    public Contract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicle) {
        DateOfContract = dateOfContract;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicle = vehicle;

    }

    public String getDateOfContract() {
        return DateOfContract;
    }

    public void setDateOfContract(String dateOfContract) {
        DateOfContract = dateOfContract;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public abstract double getTotalPrice();



    public abstract double getMonthlyPayment();


}
