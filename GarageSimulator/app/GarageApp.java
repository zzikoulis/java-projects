package app;

import controller.GarageController;
import service.exceptions.FullGarageException;
import service.exceptions.PlateNumberAlreadyExistsException;
import service.exceptions.PlateNumberNotExistsException;
import service.exceptions.SpaceNotAvailableException;

import java.util.Locale;
import java.util.Scanner;

public class GarageApp {

        private static final GarageController controller = new GarageController();
        private static final Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {
            int choice;
            System.out.println("WELCOME TO GARAGE APPLICATION! (100 SPOTS CAPACITY)\n");

            do {
                printMenu();
                choice = getInputChoice();
                manageChoice(choice);
            } while (choice != 0);
        }

        private static void printMenu() {
            System.out.println("Please select one of the following options:");
            System.out.println("1. Vehicle Entrance");
            System.out.println("2. Vehicle Exit");
            System.out.println("3. Check number of available spaces");
            System.out.println("4. Total money earned until now");
            System.out.println("5. See details of the parking staff for a specific vehicle");
            System.out.println("OR");
            System.out.println("0. EXIT GARAGE APPLICATION");
        }

        private static int getInputChoice() {
            String strChoice;
            int choice;

            strChoice = sc.nextLine();
            if (isInt(strChoice)) {
                choice = Integer.parseInt(strChoice);
            } else {
                choice = -1;
            }

            return choice;
        }

        private static boolean isInt(String s) {
            try {
                Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        private static void manageChoice(int choice) {
            switch (choice) {
                case 0:
                    System.out.println("EXIT APPLICATION");
                    sc.close();
                    break;
                case 1:
                    System.out.println("You chose option 1. Vehicle Entrance");
                    vehicleEntranceHandler();
                    break;
                case 2:
                    System.out.println("You chose option 2. Vehicle Exit");
                    vehicleExitHandler();
                    break;
                case 3:
                    System.out.println("You chose option 3. Check number of available spaces");
                    checkEmptySpacesNumberHandler();
                    break;
                case 4:
                    System.out.println("You chose option 4. Total money earned until now");
                    showTotalMoneyHandler();
                    break;
                case 5:
                    System.out.println("You chose option 5. See details of the parking staff for a specific vehicle");
                    staffDetailsForVehicleHandler();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

        private static int getInputSpaceNumber() {
            String spaceNumber;
            System.out.println("Please insert the desirable space number");
            do {
                spaceNumber = sc.nextLine().trim();
                if (!spaceNumber.equals("") && isInt(spaceNumber)) {
                    return Integer.parseInt(spaceNumber);
                }
                System.out.println("The space number cannot be empty or contains characters. Please insert a valid one");
            } while (true);
        }

        private static String getInputPlateNumber() {
            String plateNumber;
            System.out.println("Please insert the plate number of the vehicle");
            do {
                plateNumber = sc.nextLine().trim();
                if (!plateNumber.equals("")) {
                    return plateNumber;
                }
                System.out.println("Plate number is empty. Please insert a valid one.");
            } while (true);
        }

        private static String getInputVehicleType() {
            String vehicleType;
            System.out.println("Please insert '1' for Car or '2' for Motorcycle");
            do {
                vehicleType = sc.nextLine().trim();
                if (vehicleType.equals("1") || vehicleType.equals("2")) {
                    return vehicleType;
                }
                System.out.println("Invalid option. Please insert a valid one.");
            } while (true);
        }

        private static String getInputDriverFirstName() {
            String driverFirstname;
            System.out.println("Please insert the firstname of the driver");
            do {
                driverFirstname = sc.nextLine().trim();
                if (!driverFirstname.equals("") && !driverFirstname.matches(".*\\d.*")) {
                    return driverFirstname;
                }
                System.out.println("The firstname of the driver cannot be empty or contains digits. Please insert a valid one.");
            } while (true);
        }

        private static String getInputDriverLastname() {
            String driverLastname;
            System.out.println("Please insert the lastname of the driver");
            do {
                driverLastname = sc.nextLine().trim();
                if (!driverLastname.equals("") && !driverLastname.matches(".*\\d.*")) {
                    return driverLastname;
                }
                System.out.println("The lastname of the driver cannot be empty or contains digits. Please insert a valid one.");
            } while (true);
        }

        private static String getInputStaffFirstname() {
            String staffFirstname;
            System.out.println("Please insert the firstname of the parking staff");
            do {
                staffFirstname = sc.nextLine().trim();
                if (!staffFirstname.equals("") && !staffFirstname.matches(".*\\d.*")) {
                    return staffFirstname;
                }
                System.out.println("The firstname of the parking staff cannot be empty or contains digits. Please insert a valid one.");
            } while (true);
        }

        private static String getInputStaffLastname() {
            String staffLastname;
            System.out.println("Please insert the lastname of the parking staff");
            do {
                staffLastname = sc.nextLine().trim();
                if (!staffLastname.equals("") && !staffLastname.matches(".*\\d.*")) {
                    return staffLastname;
                }
                System.out.println("The lastname of the parking staff cannot be empty or contains digits. Please insert a valid one.");
            } while (true);
        }

        public static void vehicleEntranceHandler() {
            String plateNumber;
            String isCar;
            String driverFirstname;
            String driverLastname;
            String staffFirstname;
            String staffLastname;
            int spaceNumber;

            try {
                System.out.println("Available spaces are:\n " + controller.showEmptySpacesController());
            } catch (FullGarageException e) {
                System.out.println(e.getMessage());
                System.out.println();
                return;
            }

            spaceNumber = getInputSpaceNumber();
            plateNumber = getInputPlateNumber();
            isCar = getInputVehicleType();
            driverFirstname = getInputDriverFirstName();
            driverLastname = getInputDriverLastname();
            staffFirstname = getInputStaffFirstname();
            staffLastname = getInputStaffLastname();

            try {
                controller.vehicleEntranceController(spaceNumber, plateNumber, isCar, driverFirstname, driverLastname, staffFirstname, staffLastname);
            } catch (PlateNumberAlreadyExistsException | FullGarageException | SpaceNotAvailableException e) {
                System.out.println(e.getMessage());
                System.out.println();
                return;
            }

            System.out.printf("%s with plate number: '%s' inserted at position: %d\n\n", isCar.equals("1") ? "Car" : "Motorcycle", plateNumber, spaceNumber);
        }

        public static void vehicleExitHandler() {
            String plateNumber;
            double parkingCost;

            plateNumber = getInputPlateNumber();

            try {
                parkingCost = controller.vehicleExitController(plateNumber);
            } catch (PlateNumberNotExistsException e) {
                System.out.println(e.getMessage());
                System.out.println();
                return;
            }

            System.out.printf("Vehicle with plate number: '%s' exited successfully\n", plateNumber);
            if (parkingCost == 0.0) {
                System.out.println("There is no parking cost! Parking was less than 30 minutes\n");
            } else {
                System.out.printf(Locale.ENGLISH,"Parking cost is: %.2f\n\n",parkingCost);
            }
        }

        public static void checkEmptySpacesNumberHandler() {
            int emptySpaces;

            emptySpaces = controller.checkEmptySpacesNumberController();
            System.out.println("Available Spaces: " + emptySpaces);
            if (emptySpaces == 0) {
                System.out.println("Garage is full!");
            }
            System.out.println();
        }

        public static void showTotalMoneyHandler() {
            System.out.printf(Locale.ENGLISH,"Total Money: %.2f\n\n", controller.showTotalMoneyController());
        }

        public static void staffDetailsForVehicleHandler() {
            String plateNumber;
            String parkingStaffDetails;

            plateNumber = getInputPlateNumber();
            try {
                parkingStaffDetails = controller.getStaffDetailsController(plateNumber);
            } catch (PlateNumberNotExistsException e) {
                System.out.println(e.getMessage());
                System.out.println();
                return;
            }
            System.out.printf("For vehicle with plate number: '%s'\n", plateNumber);
            System.out.println(parkingStaffDetails);
        }

}

