package org.example.contract;

import org.example.Vehicle;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private double recordingFees;
    public double processingFee;
    private boolean financeOption;


    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicle, boolean financeOption) {
        super(dateOfContract, customerName, customerEmail, vehicle);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFees = 100;
        this.processingFee = processingFee;
        this.financeOption = financeOption;
    }

    public double getSalesTaxAmount() {
        return getVehicle().getPrice() * 0.05;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFees() {
        return 100;
    }

    public void setRecordingFees(double recordingFees) {
        this.recordingFees = recordingFees;
    }

    public double getProcessingFee() {
        if(getVehicle().getPrice()<10000){
            return 295;
        }else{
            return 495;
        }
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanceOption() {
        return financeOption;
    }

    public void setFinanceOption(boolean financeOption) {
        this.financeOption = financeOption;
    }

    @Override
    public double getTotalPrice() {
      return getVehicle().getPrice() + getSalesTaxAmount() + getRecordingFees() + getProcessingFee();

    }

    @Override
    public double getMonthlyPayment() {
        if(!financeOption){
            return 0;
        }
        double p = getVehicle().getPrice();
        double r;
        double n = 0;
        if(getVehicle().getPrice() >=  10000 ){
            r = 0.0425/12;
            n = 48;
        }else{
            r = 0.0525/12;
            n = 24;
        }
        double top = p * r *(Math.pow(1 + r, n));
        double bottom = (Math.pow(1 + r, n)-1);
        return top/bottom;
    }
}
