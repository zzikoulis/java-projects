package gr.aueb.cf.projects10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Project2 {

    public static void main(String[] args) {
        String[][] contacts = new String[500][3];
        Scanner in = new Scanner(System.in);
        int userOption;
        int totalContacts = 0;
        System.out.println("Contacts Management App");
        System.out.println();

        do {
            userOption = readOption(in);
            switch(userOption) {
                case 1:
                    System.out.println("You chose to search a contact by telephone number");
                    System.out.println();
                    searchContact(in, contacts, totalContacts);
                    break;
                case 2:
                    System.out.println("You chose to insert a new contact");
                    System.out.println();
                    totalContacts = insertContact(in, contacts, totalContacts);
                    break;
                case 3:
                    System.out.println("You chose to update a contact");
                    System.out.println();
                    updateContact(in, contacts, totalContacts);
                    break;
                case 4:
                    System.out.println("You chose to delete a contact");
                    System.out.println();
                    totalContacts = deleteContact(in, contacts, totalContacts);
                    break;
                default:
            }
        } while (userOption != 0);

        System.out.println("You chose to exit app. Bye.");
        in.close();

    }

    public static int readOption(Scanner in) {
        int userOption = -1;
        boolean exception;

        do {
            exception = false;
            System.out.println("Please choose:");
            System.out.println("1. Search a contact by telephone number");
            System.out.println("2. Insert a new contact");
            System.out.println("3. Update a contact");
            System.out.println("4. Delete a contact");
            System.out.println("or 0 to exit app");
            System.out.println("and press Enter");

            try {
                userOption = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.printf("Please insert a valid option\n\n");
                in.nextLine();
                exception = true;
            }
            if((userOption > -1) && (userOption <5)) break;

            if(!exception) {
                System.out.printf("You chose: %d. Please insert a valid option\n\n", userOption);
            }
        }while(true);

        return userOption;
    }

    public static void searchContact(Scanner in, String[][] contacts, int totalContacts) {
        System.out.println("Please insert a telephone number to search and press Enter:");
        boolean found = false;
        int positionFound = -1;
        String telephone = in.next();

        for (int i = 0; i < totalContacts; i++) {
            if (contacts[i][2].compareTo(telephone) == 0){
                found = true;
                positionFound = i;
            }
        }

        if (found) {
            System.out.println("Contact found!");
            System.out.printf("Lastname: %s | Firstname: %s | Tel. Number: %s\n", contacts[positionFound][0], contacts[positionFound][1], contacts[positionFound][2]);
        } else {
            System.out.println("Contact not found!");
            System.out.println("Please try again");
        }

        System.out.println();
    }

    public static boolean telephoneFound(String telephone,String[][] contacts, int totalContacts) {
        boolean found = false;

        for (int i = 0; i < totalContacts; i++) {
            if (contacts[i][2].compareTo(telephone) == 0){
                found = true;
                break;
            }
        }

        return found;
    }


    public static int insertContact(Scanner in, String[][] contacts, int totalContacts) {
        System.out.println("Please insert a telephone number to insert and press Enter:");
        String telephone = in.next();

        if(telephoneFound(telephone, contacts, totalContacts)) {
            System.out.println("There is already a contact with this telephone number.");
            System.out.println("Contact can not be inserted again.");
        } else {
            if(totalContacts == 500) {
                System.out.println("Contacts' memory capacity has reached 500 contacts.");
                System.out.println("Please delete a contact in order to insert a new one.");
                System.out.println();
                return totalContacts;
            }
            contacts[totalContacts][2] = telephone;
            System.out.println("Please insert a Lastname to insert and press Enter:");
            contacts[totalContacts][0] = in.next();
            System.out.println("Please insert a Firstname to insert and press Enter:");
            contacts[totalContacts][1] = in.next();
            totalContacts++;
            System.out.println("Contact inserted successfully!");
        }
        System.out.println();
        return totalContacts;
    }

    public static void updateContact(Scanner in, String[][] contacts, int totalContacts) {
        boolean found = false;
        int positionFound = -1;
        System.out.println("Please insert a Tel. number or Lastname or Firstname about a contact you want to update and press Enter:");
        String element = in.next();

        for (int i = 0; i < totalContacts; i++) {
            if ((contacts[i][0].compareTo(element) == 0) ||
                    (contacts[i][1].compareTo(element) == 0) ||
                        (contacts[i][2].compareTo(element) == 0)) {
                found = true;
                positionFound = i;
            }
        }

        if(!found) {
            System.out.println("There is no contact with these elements.");
            System.out.println("Update can not be continued.");
        } else {
            System.out.printf("Contact found with elements: ");
            System.out.printf("Lastname: %s | Firstname: %s | Tel. Number: %s\n", contacts[positionFound][0], contacts[positionFound][1], contacts[positionFound][2]);
            System.out.println("Please insert a Tel. Number to update and press Enter:");
            contacts[positionFound][2] = in.next();
            System.out.println("Please insert a Lastname to update and press Enter:");
            contacts[positionFound][0] = in.next();
            System.out.println("Please insert a Firstname to update and press Enter:");
            contacts[positionFound][1] = in.next();
            System.out.println("Contact updated successfully!");
        }
        System.out.println();
    }

    public static int deleteContact(Scanner in, String[][] contacts, int totalContacts) {
        boolean found = false;
        int positionFound = -1;
        System.out.println("Please insert a Tel. number or Lastname or Firstname about a contact you want to delete and press Enter:");
        String element = in.next();

        for (int i = 0; i < totalContacts; i++) {
            if ((contacts[i][0].compareTo(element) == 0) ||
                    (contacts[i][1].compareTo(element) == 0) ||
                    (contacts[i][2].compareTo(element) == 0)) {
                found = true;
                positionFound = i;
            }
        }

        if(!found) {
            System.out.println("There is no contact with these elements.");
            System.out.println("Delete can not be continued.");
        } else {
            System.out.printf("Contact found with elements: ");
            System.out.printf("Lastname: %s | Firstname: %s | Tel. Number: %s\n", contacts[positionFound][0], contacts[positionFound][1], contacts[positionFound][2]);
            totalContacts--;
            for (int i = positionFound; i < totalContacts; i++) {
                contacts[i][0] = contacts[i+1][0];
                contacts[i][1] = contacts[i+1][1];
                contacts[i][2] = contacts[i+1][2];
            }
            System.out.println("Contact deleted successfully!");
        }
        System.out.println();
        return totalContacts;
    }
}
