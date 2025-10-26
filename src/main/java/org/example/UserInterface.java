package org.example;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

//import static sun.tools.jconsole.OutputViewer.init;

//import static sun.tools.jconsole.OutputViewer.init;

public class UserInterface {
    public static Scanner scanner = new Scanner(System.in);

    private Dealership dealership;

    public UserInterface(){
        init();
    }
    private void displayVehicle(List<Vehicle>vehicles){

    }

    private void init()  {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();

        if (this.dealership == null){
            System.out.println("ERROR: The dealership data file is missing or malformed.");
            System.out.println("Please ensure 'vehicle.csv' exists and has the correct format.");
            System.out.println("The application cannot continue.");
            System.exit(1);

            boolean isRunning = true;

            while(isRunning){
                System.out.println("Welcome to my Dealership, this is the best place to buy a vehicle");
                System.out.println("Select from the following options:");
                System.out.println("""
                       1. View all vehicles
                       2. Search for vehicles by price
                       3. Search for vehicles by make/model
                       4. Search for vehicle by year
                       5. Search for vehicle by color
                       6. Search for vehicle by mileage
                       7. Search for vehicle by vehicleType
                       8. Add a vehicle
                       9. Remove a vehicle
                       10.Exit Program
                       """);

                try{
                    int userInput = scanner.nextInt();
                }

            }
        }

    }
    public void processGetByPriceRequest(){
        boolean isGettingByPrice = true;

        while(isGettingByPrice){
            try{
                System.out.println("What is the minimum price of the vehicle you are looking for?");
                double minPrice = scanner.nextDouble();
                System.out.println("What is the maximum price of the vehicle you are looking for?");
                double maxPrice = scanner.nextDouble();

                if (minPrice < maxPrice){
                    System.out.printf("Here are all the vehicles between %d and %d", minPrice,maxPrice);
                    List<Vehicle> vehicleList = dealership.getVehicleByPrice(minPrice,maxPrice);
                    displayVehicle(vehicleList);
                    isGettingByPrice = false;
                }else{
                    System.out.println("The minimum price must be less than the maximum price.Please try again.");
                }
            }
            catch (InputMismatchException ex){
                System.out.println("Invaild input.Please enter a valid number.");

            }
        }
    }
    public void processGetByMakeModelRequest(){
        boolean isGettingByMakeModel = true;

        while (isGettingByMakeModel){
            try{
                System.out.println("Enter the make of the vehicle you are looking for:");
                String make = scanner.nextLine();
                System.out.println("Enter the model of the vehicle you are looking for:");
                String model = scanner.nextLine();

                List<Vehicle>vehicleList = dealership.getVehicleMakeModel(make,model);
                displayVehicle(vehicleList);
                isGettingByMakeModel = false;

            }
            catch (InputMismatchException ex){
                System.out.println("Invalid");
            }
        }
    }
    public void processAllVehiclesRequest(){
        this.dealership.getAllVehicles();
    }
    public void processAddVehicleRequest(){
        boolean isAddingVehicle = true;

        while (isAddingVehicle){
            try{
                System.out.println("Enter the vehicle make:");
                String make = scanner.nextLine();
                System.out.println("Enter vehicle model:");
                String model = scanner.nextLine();
                System.out.println("Enter vehicle year:");
                int year = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter vehicle price:");
                double price = Double.parseDouble(scanner.nextLine());

                Vehicle newVehicle = new Vehicle(make, model, year, price);
                this.dealership.addVehicle(newVehicle);

                System.out.println("Vehicle added successfully!");

                System.out.println("Add another vehicle (y/n):");
                String choice = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
                if (!choice.equals("y")){
                    isAddingVehicle = false;
                }
            }
            catch (NumberFormatException ex){
                System.out.println("Invalid input");
            } catch (Exception e) {
                System.out.println("Error:" + e.getMessage());
            }
        }
    }


}
