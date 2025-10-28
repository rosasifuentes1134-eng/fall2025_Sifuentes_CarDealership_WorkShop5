package org.example;



import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    static Scanner scanner = new Scanner(System.in);


    public void displayVehicle(List<Vehicle> vehicles) {

        for (Vehicle vehicle : vehicles) {
            System.out.printf("%d|%d|%s|%s|%s|%s|%d|%f %n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake()
                    , vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());

        }

    }

    private void init() {
        this.dealership = DealershipFileManager.getDealership();
    }

    public void display() {
        init();

        if (this.dealership == null) {
            System.out.println("ERROR: failed tp load");
            return;
        }
        boolean isRunning = true;

        while (isRunning) {
            try {
                System.out.println("Welcome to my Dealership, this is the best place to buy a vehicle");
                System.out.println("Select from the following options:");

                System.out.println("=".repeat(100));
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
                        0.Exit Program
                        """);
                System.out.println("=".repeat(100));


                int userInput = Integer.parseInt(scanner.nextLine());

                switch (userInput) {
                    case 1:
                        processGetAllVehiclesRequest();
                        break;
                    case 2:
                        processGetByPriceRequest();
                        break;
                    case 3:
                        processGetByMakeModelRequest();
                        break;
                    case 4:
                        processGetByYearRequest();
                        break;
                    case 5:
                        processGetByColorRequest();
                        break;
                    case 6:
                        processGetByMileageRequest();
                        break;
                    case 7:
                        processGetByVehicleTypeRequest();
                        break;
                    case 8:
                        processAddVehicleRequest();
                        break;
                    case 9:
                        processRemoveVehicleRequest();
                        break;
                    case 0:
                        isRunning = false;
                        System.out.println("Exit. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }


            }
            catch(NumberFormatException ex){
                System.out.println("Number format.");
            }
            catch (Exception ex) {
                System.out.println("Invalid option.Please choose a number provided.");

            }
        }
    }


    public void processGetByPriceRequest() {
        boolean isGettingByPrice = true;

        while (isGettingByPrice) {
            boolean isRunning = true;
            while (isRunning) {
                System.out.println("What is the minimum price of the vehicle you are looking for?");
                double minPrice = Double.parseDouble(scanner.nextLine());
                System.out.println("What is the maximum price of the vehicle you are looking for?");
                double maxPrice = Double.parseDouble(scanner.nextLine());

                if (minPrice < maxPrice) {
                    System.out.printf("Here are all the vehicles between %f and %f", minPrice, maxPrice);
                    List<Vehicle> vehicleList = dealership.getVehicleByPrice(minPrice, maxPrice);
                    displayVehicle(vehicleList);
                    isRunning = false;
                    isGettingByPrice = false;
                } else {
                    System.out.println("The minimum price must be less than the maximum price.Please try again.");
                }
            }
        }
    }

    public void processGetByMakeModelRequest() {
        boolean isGettingByMakeModel = true;

        while (isGettingByMakeModel) {

            System.out.println("Enter the make of the vehicle you are looking for:");
            String make = scanner.nextLine();
            System.out.println("Enter the model of the vehicle you are looking for:");
            String model = scanner.nextLine();

            List<Vehicle> vehicleList = dealership.getVehicleMakeModel(make, model);
            displayVehicle(vehicleList);
            isGettingByMakeModel = false;

        }
    }

    public void processGetByYearRequest() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Enter the minimum year of the vehicle you are looking for:");
            int minYear = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the maximum year of the vehicle you are looking for:");
            int maxYear = Integer.parseInt(scanner.nextLine());

            if (minYear < maxYear) {
                System.out.printf("Here are all the vehicles between %d and %d", minYear, maxYear);
                List<Vehicle> vehicleList = dealership.getVehicleByPrice(minYear, maxYear);
                displayVehicle(vehicleList);
                isRunning = false;
            } else {
                System.out.println("The minimum price must be less than the maximum price.Please try again.");
            }
        }

    }
    public void processGetByColorRequest(){
        System.out.println("Enter color:");
        String color = scanner.nextLine();
        displayVehicle(dealership.getVehicleColor(color));

    }
    public void processGetByMileageRequest() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Enter minimum mileage:");
            int minMileage = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter maximum mileage:");
            int maxMileage = Integer.parseInt(scanner.nextLine());
            if (minMileage > maxMileage) {
                System.out.println("Invalid mileage range.");
            } else {
                isRunning = false;
                displayVehicle(dealership.getVehicleMileage(minMileage, maxMileage));
            }
        }

    }
    public void processGetByVehicleTypeRequest() {
        System.out.println("Enter vehicle type:");
        String vehicleType = scanner.nextLine();
        displayVehicle(dealership.getVehicleByType(vehicleType));

    }


    public void processGetAllVehiclesRequest() {
       displayVehicle(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {
        boolean isAddingVehicle = true;

        while (isAddingVehicle) {
            try {
                System.out.println("Enter the vin number:");
                int vin = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter the year:");
                int year = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter the vehicle make:");
                String make = scanner.nextLine();
                System.out.println("Enter vehicle model:");
                String model = scanner.nextLine();
                System.out.println("Enter vehicleType:");
                String vehicleType = scanner.nextLine();
                System.out.println("Enter vehicle color:");
                String color = scanner.nextLine();
                System.out.println("Enter odometer");
                int odometer = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter vehicle price:");
                double price = Double.parseDouble(scanner.nextLine());

                Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                //this.dealership.addVehicle(newVehicle);
                System.out.println("Vehicle successfully added!");

                System.out.println("Add another vehicle (y/n):");
                String choice = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
                if (!choice.equals("y")) {
                    isAddingVehicle = false;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input");
            } catch (Exception e) {
                System.out.println("Error:" + e.getMessage());
            }
        }
    }

    public void processRemoveVehicleRequest() {
        System.out.println("Enter thr vin number to remove:");
        int vin = Integer.parseInt(scanner.nextLine());
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                System.out.println("Vehicle found:");
                System.out.printf("%-5d|%-6d|%-10s|%-10s|%-15s|%-10s|%-10d|$%-10.2f\n",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice());

                System.out.println("vehicle remove successfully!");
                scanner.nextLine();
            }
        }

    }

}
