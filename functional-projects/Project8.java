package gr.aueb.cf.projects10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Project8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String player1, player2;
        char[][] triliza = new char[3][3];

        initTriliza(triliza);
        System.out.println("Welcome to Triliza Game!!!");
        System.out.println();
        System.out.println("Please insert a name for Player1 and press Enter:");
        player1 = in.next();
        System.out.printf("%s,your symbol is X\n\n", player1);
        System.out.println("Please insert a name for Player2 and press Enter:");
        player2 = in.next();
        System.out.printf("%s,your symbol is O\n\n", player2);

        playTrilizaGame(in, triliza, player1, player2);

    }

    public static void initTriliza(char[][] triliza) {
        for(int i = 0; i < triliza.length; i++) {
            for (int j = 0; j < triliza.length; j++) {
                triliza[i][j] = ' ';
            }
        }
    }

    public static void playTrilizaGame(Scanner in, char[][] triliza, String player1, String player2) {
        int cellsFull = 0;
        int playerNum = 1;
        System.out.println("Let's start the game!\n");

        do {
            if(playerNum == 1) {
                System.out.println(player1 + ", is your turn");
            } else {
                System.out.println(player2 + ", is your turn");
            }

            chooseCell(in ,triliza, playerNum);

            if(checkForTriliza(triliza)) {
                printTriliza(triliza);
                if(playerNum == 1) {
                    System.out.printf("%s you are the winner!", player1);
                } else {
                    System.out.printf("%s you are the winner!", player2);
                }
                System.out.println("Game over!");
                return;
            }
            if(playerNum == 1) {
                playerNum =2;
            } else {
                playerNum = 1;
            }
            cellsFull++;
        } while (cellsFull < 9);

        printTriliza(triliza);
        System.out.println("Game over! Game is tie!");
    }

    public static void printTriliza(char[][] triliza) {
        System.out.println("  |  1  |  2  |  3  |");
        System.out.println("--|-----|-----|-----|--");
        for (int i = 0; i < triliza.length; i++) {
            System.out.printf("%d ", i + 1);
            for (int j = 0; j < triliza[i].length; j++) {
                System.out.print("|  " + triliza[i][j] + "  ");
            }
            System.out.println("|");
            System.out.println("--|-----|-----|-----|--");
        }
        System.out.println();
    }

    public static void chooseCell(Scanner in, char[][] triliza, int playerNum) {
        int row, column;

        do {
            System.out.println("Choose a free row and column separated by space(ex. 1 3) and press Enter");
            printTriliza(triliza);
            try{
                row = in.nextInt() - 1;
                column = in.nextInt() - 1;
                if((row >= 0) && (row < 3) && (column >= 0) && (column < 3)) {
                    if(triliza[row][column] == ' ') {
                        if (playerNum == 1) {
                            triliza[row][column] = 'X';
                        } else {
                            triliza[row][column] = 'O';
                        }
                        System.out.println("Your choice stored successfully\n");
                        break;
                    }
                    else {
                        System.out.printf("Cell %d %d is full. Please choose a free one.\n", row + 1, column + 1);
                    }

                } else {
                    System.out.println("Rows and columns must be between 1 and 3. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong format. Please try again.");
                in.nextLine();
            }
        } while(true);
    }

    public static boolean checkForTriliza(char[][] triliza) {
        if((triliza[0][0] == triliza[0][1]) && (triliza[0][1] == triliza[0][2]) && (triliza[0][2] != ' '))
            return true;
        if((triliza[1][0] == triliza[1][1]) && (triliza[1][1] == triliza[1][2]) && (triliza[1][2] != ' '))
            return true;
        if((triliza[2][0] == triliza[2][1]) && (triliza[2][1] == triliza[2][2]) && (triliza[2][2] != ' '))
            return true;
        if((triliza[0][0] == triliza[1][0]) && (triliza[1][0] == triliza[2][0]) && (triliza[2][0] != ' '))
            return true;
        if((triliza[0][1] == triliza[1][1]) && (triliza[1][1] == triliza[2][1]) && (triliza[2][1] != ' '))
            return true;
        if((triliza[0][2] == triliza[1][2]) && (triliza[1][2] == triliza[2][2]) && (triliza[2][2] != ' '))
            return true;
        if((triliza[0][0] == triliza[1][1]) && (triliza[1][1] == triliza[2][2]) && (triliza[2][2] != ' '))
            return true;
        if((triliza[2][0] == triliza[1][1]) && (triliza[1][1] == triliza[0][2]) && (triliza[0][2] != ' '))
            return true;
        return false;
    }
}
