package org.example;



import org.example.contract.Contract;
import org.example.contract.LeaseContract;
import org.example.contract.SalesContract;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContractDataManager {
    public static void saveContract(Contract contract) {
       List<Contract> contracts = new ArrayList<>();

        try {
            FileWriter fw = new FileWriter("src/main/resources/contract.csv",true);
            BufferedWriter writer = new BufferedWriter(fw);

            if (contract instanceof SalesContract){
                writesSalesContract(writer,(SalesContract) contract);
            } else if (contract instanceof LeaseContract) {
                writeLeaseContract(writer,(LeaseContract) contract);

            }

            writer.close();
            fw.close();
            System.out.println("Contract saved");

        } catch (IOException e) {
            System.out.println("File saved to contract");
        }
    }
    public static void writesSalesContract(BufferedWriter writer,SalesContract contract){
        Vehicle vehicle = contract.getVehicle();

        String line = "sales" + "|" +
                contract.getDateOfContract() + "|"+
                contract.getCustomerName() + "|"+
                contract.getCustomerEmail() + "|"+
                vehicle.getVin() +"|"+
                vehicle.getYear() +"|"+
                vehicle.getMake() +"|"+
                vehicle.getModel() +"|"+
                vehicle.getVehicleType() +"|"+
                vehicle.getColor() +"|"+
                vehicle.getOdometer() +"|"+
                vehicle.getPrice() +"|"+
                contract.getSalesTaxAmount() +"|"+
                contract.getRecordingFees() +"|"+
                contract.getProcessingFee() +"|"+
                contract.getTotalPrice() +"|"+
                (contract.isFinanceOption()?"Yes": "No") +"|"+
                contract.getMonthlyPayment();



        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Failed to write in sales contract");
        }
    }
    public  static void writeLeaseContract(BufferedWriter writer, LeaseContract contract){
        Vehicle vehicle = contract.getVehicle();

        String line = "Lease"+ "|"+
                contract.getDateOfContract() + "|"+
                contract.getCustomerName() + "|"+
                contract.getCustomerEmail() + "|"+
                vehicle.getVin() +"|"+
                vehicle.getYear() +"|"+
                vehicle.getMake() +"|"+
                vehicle.getModel() +"|"+
                vehicle.getVehicleType() +"|"+
                vehicle.getColor() +"|"+
                vehicle.getOdometer() +"|"+
                vehicle.getPrice() +"|"+
                contract.getEndingValue() +"|"+
                contract.getLeaseFee() +"|"+
                contract.getTotalPrice() +"|"+
                contract.getMonthlyPayment();

        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error file");
        }
    }
}

