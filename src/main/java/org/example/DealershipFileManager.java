package org.example;


//import org.example.Vehicle;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DealershipFileManager {


    public static Dealership getDealership() {
        Dealership dealership = new Dealership();


        try {
            FileReader fr = new FileReader("src/main/resources/inventory.csv");
            BufferedReader reader = new BufferedReader(fr);

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");

                int vin = Integer.parseInt(data[0]);
                int year = Integer.parseInt(data[1]);
                String make = data[2];
                String model = data[3];
                String vehicleType = data[4];
                String color = data[5];
                int odometer = Integer.parseInt(data[6]);
                double price = Double.parseDouble(data[7]);
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                dealership.addVehicle(vehicle);

            }
            reader.close();
            fr.close();

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } catch (Exception ex) {
        }
        return dealership;

    }

    //we need something to open up the file
    public static void saveDealership(Dealership dealership) {
        try {
            FileWriter fw = new FileWriter("src/main/resources/inventory.csv");
            BufferedWriter writer = new BufferedWriter(fw);

            String headerRow = String.format("%s|%s|%s %n", dealership.getName(), dealership.getAddress(),
                    dealership.getAddress(), dealership.getPhoneNumber());
            fw.write(headerRow);

            List<Vehicle> vehicles = dealership.getAllVehicles();
            for (Vehicle vehicle : vehicles) {

                fw.write(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f %n",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice()));
            }
            writer.close();

            fw.close();
        } catch (Exception ex) {

        }

    }


}






