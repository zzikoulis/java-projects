package gr.aueb.cf.projects10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Project10 {

    public static void main(String[] args) {
        boolean[][] theatre = null;
        int rows = 20;
        int seatsPerRow = 12;

        theatre = initTheatre(rows, seatsPerRow);
        manageTheatre(theatre, rows, seatsPerRow);

    }

    public static boolean[][] initTheatre(int rows, int seatsPerRow) {
        boolean[][] theatre = new boolean[rows][seatsPerRow];

        for (boolean[] row : theatre) {
            for (boolean seat : row) {
                seat = false;
            }
        }

        return theatre;
    }

    public static void manageTheatre(boolean[][] theatre, int rows, int seatsPerRow) {
        Scanner in = new Scanner(System.in);
        int userOption;
        System.out.println("Welcome to Theatre Book Management App");
        System.out.println();

        do {
            userOption = readOption(in);
            if(userOption == 0)
                break;
            if(userOption == 1) {
                System.out.println("You chose to book a seat");
                System.out.println();
            } else {
                System.out.println("You chose to cancel a book");
                System.out.println();
            }

            manageOption(in, theatre, rows, seatsPerRow, userOption);

        } while (true);

        System.out.println("You chose to exit app. Bye.");
        in.close();
    }

    public static int readOption(Scanner in) {
        int userOption = -1;
        boolean exception;

        do {
            exception = false;
            System.out.println("Please choose:");
            System.out.println("1 for book a seat");
            System.out.println("2 for cancel a book");
            System.out.println("or 0 to exit app");
            System.out.println("and press Enter");

            try {
                userOption = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.printf("Please insert a valid option\n\n");
                in.nextLine();
                exception = true;
            }
            if((userOption == 0) || (userOption == 1) || (userOption == 2)) break;

            if(!exception) {
                System.out.printf("You chose: %d. Please insert a valid option\n\n", userOption);
            }
        }while(true);

        return userOption;
    }

    public static void manageOption(Scanner in, boolean[][] theatre, int rows, int seatsPerRow, int userOption) {
        int userRow, userSeat;

        userRow = readRow(in, rows);
        if(userRow == -1)
            return;

        userSeat = readSeat(in, seatsPerRow);
        if (userSeat == -1)
            return;

        if (userOption == 1){
            book(theatre, userRow, userSeat);
        } else {
            cancel(theatre, userRow, userSeat);
        }
    }

    public static int readRow(Scanner in, int rows) {
        int userRow = -1;

        System.out.println("Please choose on of the following rows and press Enter:");
        for (int i = 0; i < rows; i++) {
            System.out.printf("- %c ", (char) 65 + i);
        }
        System.out.println();

        userRow = in.next().charAt(0);
        if ((userRow > 64) && (userRow < 64 + rows + 1)) {
            System.out.printf("You chose row: %c\n\n", (char) userRow);
        }
        else {
            System.out.printf("You chose a wrong row: %c\n", (char) userRow);
            System.out.println("Please try again");
            System.out.println();
            return -1;
        }

        return userRow;
    }

    public static int readSeat(Scanner in, int seatsPerRow) {
        int userSeat = -1;

        System.out.println("Please choose on of the following seats and press Enter:");
        for (int i = 0; i < seatsPerRow; i++) {
            System.out.printf("- %d ", i + 1);
        }
        System.out.println();

        try {
            userSeat = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("You chose a wrong seat");
            System.out.println("Please try again");
            System.out.println();
            return -1;
        }
        if((userSeat > 0) && (userSeat < seatsPerRow + 1)) {
            System.out.printf("You chose seat: %d\n\n", userSeat);
        }
        else {
            System.out.printf("You chose a wrong seat: %d\n", userSeat);
            System.out.println("Please try again");
            System.out.println();
            return -1;
        }

        return userSeat;
    }

    public static void book(boolean[][] theatre, int userRow, int userSeat) {
        if (!theatre[userRow - 65][userSeat - 1]) {
            theatre[userRow - 65][userSeat - 1] = true;
            System.out.printf("Seat %c%d has successfully booked\n", (char)userRow, userSeat);
            System.out.println();
        }
        else {
            System.out.printf("Seat %c%d has already booked\n", (char)userRow, userSeat);
            System.out.println("Please try again to book for another seat");
            System.out.println();
        }
    }

    public static void cancel(boolean[][] theatre, int userRow, int userSeat) {
        if (theatre[userRow - 65][userSeat - 1]) {
            theatre[userRow - 65][userSeat - 1] = false;
            System.out.printf("Book for seat %c%d has successfully cancelled\n", (char)userRow, userSeat);
            System.out.println();
        }
        else {
            System.out.printf("Seat %c%d is free.\n", (char)userRow, userSeat);
            System.out.println("There is no book to cancel for this seat");
            System.out.println();
        }
    }

}
