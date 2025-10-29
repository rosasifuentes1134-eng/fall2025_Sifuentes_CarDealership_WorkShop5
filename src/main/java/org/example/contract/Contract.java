package org.example.contract;

public abstract class Contract {
    private String DateOfContract;
    private String customerName;
    private String customerEmail;
    private boolean vehicleSold;


    public Contract(String dateOfContract, String customerName, String customerEmail, boolean vehicleSold) {
        DateOfContract = dateOfContract;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;

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

    public boolean isVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(boolean vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public abstract double getTotalPrice();



    public abstract double getMonthlyPayment();


}
