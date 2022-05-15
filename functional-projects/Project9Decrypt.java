package gr.aueb.cf.projects10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Project9Decrypt {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int decryptionKey;
        String message = null;

        decryptionKey = readDecryptionKey(in);
        message = readMessageForDecryption(in);
        printDecryptedText(decryptionKey, message);

        in.close();
    }

    public static int readDecryptionKey(Scanner in) {
        int decryptionKey = 127;

        do {
            System.out.println("Please insert a number bigger than 127 for decryption key and press Enter");

            try {
                decryptionKey = in.nextInt();
                if (decryptionKey < 128){
                    System.out.println("Invalid decryption key");
                    System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid decryption key");
                System.out.println();
                in.nextLine();
            }
        } while (decryptionKey < 128);

        in.nextLine();
        return decryptionKey;
    }

    public static String readMessageForDecryption(Scanner in) {
        String message;

        do {
            System.out.println("Please insert a message for decryption (numbers separated with spaces ending with -1) otherwise it will be asked again");

            message = in.nextLine();
        } while (!message.endsWith("-1"));

        System.out.println();
        return message;
    }

    public static void printDecryptedText(int decryptionKey, String message) {
        int characterCode = 0;
        int readNumber;
        int printCharacter;

        String[] letters= null;

        letters = message.split(" ");

        for (int i = 0; i < letters.length - 1; i++) {
            try {
                readNumber = Integer.parseInt(letters[i]);

                if (readNumber > characterCode) {
                    printCharacter = readNumber - characterCode;
                    characterCode = printCharacter;
                    System.out.print((char)printCharacter);
                } else {
                    printCharacter = readNumber + decryptionKey - characterCode;
                    characterCode = printCharacter;
                    System.out.print((char) printCharacter);
                }
            } catch (NumberFormatException e) {
                System.out.printf("DECRYPTION ERROR\n");
                System.out.println("Invalid string format for decryption.");
                System.out.println("Please run the program again");
                return;
            }
        }
    }

}

