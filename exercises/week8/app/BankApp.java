package exercises.week8.app;

import exercises.week8.model.Account;
import exercises.week8.model.JointAccount;
import exercises.week8.model.OverdraftAccount;

import java.io.FileNotFoundException;

public class BankApp {

    public static void main(String[] args) throws FileNotFoundException {
        Account alice = new Account(1, "GR111", "Wonderland", "Alice", "AB123", 100);
        OverdraftAccount bob = new OverdraftAccount(1, "GR111", "Marley", "Bob", "AB321", 100);
        JointAccount aliceBob = new JointAccount(1, "GR333", "Wonderland", "Alice", "AB123", "Marley", "Bob", "AB321", 100);

        if (alice.withdraw(100, "AB123")) {
            System.out.println("Success");
        } else {
            System.out.println("Error");
        }

        if (bob.withdraw(200, "AB321")) {
            System.out.println("Success");
        } else {
            System.out.println("Error");
        }

        if (bob.withdraw(200, "AB321")) {
            System.out.println("Success");
        } else {
            System.out.println("Error");
        }

        if (aliceBob.withdraw(10, "AB123")) {
            System.out.println("Success");
        } else {
            System.out.println("Error");
        }

        if (aliceBob.withdraw(10, "AB321")) {
            System.out.println("Success");
        } else {
            System.out.println("Error");
        }

        if (aliceBob.withdraw(10, "AB")) {
            System.out.println("Success");
        } else {
            System.out.println("Error");
        }
    }
}
