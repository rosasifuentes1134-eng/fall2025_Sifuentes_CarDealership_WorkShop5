package org.example.contract;

import org.example.Vehicle;

public class LeaseContract extends Contract {
    private double endingValue;
    private double leaseFee;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicle, double endingValue, double leaseFee) {
        super(dateOfContract, customerName, customerEmail, vehicle);
        this.endingValue = endingValue;
        this.leaseFee = leaseFee;
    }

    public double getEndingValue() {
        return endingValue;
    }

    public void setEndingValue(double endingValue) {
        this.endingValue = endingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        double originalPrice = getVehicle().getPrice();
        //ending value 50% and lease fee 7%
        double endingValue = originalPrice * 0.50;
        double leaseFee = originalPrice * 0.07 ;
        //Total finance amount lease price before interest
        double totalPrice = (originalPrice - endingValue) + leaseFee;
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        double originalPrice = getVehicle().getPrice();
        double endingValue = originalPrice * 0.50;
        double leaseFee = originalPrice * 0.07;
        double amountFinanced = (originalPrice - endingValue) + leaseFee;
        //Financing details
        double annualRate = 0.04;
        double monthlyRate = annualRate / 12;
        int months = 36;
        //Monthly payment formula
        double monthlyPayment = (monthlyRate * amountFinanced) / (1 - Math.pow(1 + monthlyRate, -months));
        return monthlyPayment;
    }
}
