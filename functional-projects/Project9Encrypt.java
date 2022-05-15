package gr.aueb.cf.projects10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Project9Encrypt {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int encryptionKey;
        String message = null;

        encryptionKey = readEncryptionKey(in);
        message = readMessageForEncryption(in);
        printEncryptedText(encryptionKey, message);

        in.close();
    }

    public static int readEncryptionKey(Scanner in) {
        int encryptionKey = 127;

        do {
            System.out.println("Please insert a number bigger than 127 for encryption key and press Enter");

            try {
                encryptionKey = in.nextInt();
                if (encryptionKey < 128){
                    System.out.println("Invalid encryption key");
                    System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid encryption key");
                System.out.println();
                in.nextLine();
            }
        } while (encryptionKey < 128);

        in.nextLine();
        return encryptionKey;
    }

    public static String readMessageForEncryption(Scanner in) {
        String message;

        do {
            System.out.println("Please insert a message for encryption ending with # otherwise it will be asked again");

            message = in.nextLine();
        } while (!message.endsWith("#"));

        System.out.println();
        return message;
    }

    public static void printEncryptedText(int encryptionKey, String message) {
        int counter = 0;
        int characterCode = 0;
        int printCharacter;

        System.out.println("Encrypted message is:");
        while (message.charAt(counter) != '#') {
            printCharacter = ((int) message.charAt(counter) + characterCode) % encryptionKey;
            characterCode = message.charAt(counter);
            System.out.print(printCharacter + " ");
            counter++;
        }
        System.out.println("-1");
    }

}
