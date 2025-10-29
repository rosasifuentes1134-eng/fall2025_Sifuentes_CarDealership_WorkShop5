package org.example.contract;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private double recordingFees;
    public boolean processingFee;
    private boolean ifFinance;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, boolean vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
