package exercises.week8.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class OverdraftAccount {
    private long id;
    private String iban;
    private String lastname;
    private String firstname;
    private String ssn;
    private double balance;

    public static OverdraftAccount getInstance() {
        return new OverdraftAccount();
    }

    private OverdraftAccount() {}

    public OverdraftAccount(long id, String iban, String lastname, String firstname, String ssn, double balance) {
        this.id = id;
        this.iban = iban;
        this.lastname = lastname;
        this.firstname = firstname;
        this.ssn = ssn;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Business Logic

    /**
     * Deposits an amount to this account
     * @param amount the amount of money to deposit
     */
    public boolean deposit(double amount) throws FileNotFoundException {
        if(amount > 0) {
            balance += amount;
            return true;
        } else {
            printErrorMessage(System.err, "Error: Insufficient Amount");
            printErrorMessage(new PrintStream(new FileOutputStream("log.txt", true)), "Error: Insufficient Amount");
            return false;
        }
    }

    /**
     * Withdraws a certain amount of money from the account
     * @param amount the amount of money to withdraw
     */
    public boolean withdraw(double amount, String ssn) throws FileNotFoundException {
        if(!isSsnValid(ssn)) {
            printErrorMessage(System.err, "Error: Invalid SSN");
            printErrorMessage(new PrintStream(new FileOutputStream("log.txt", true)), "Error: Invalid SSN");
            return false;
        }

        if(balance >= 0) {
            balance -= amount;
            return true;
        } else {
            printErrorMessage(System.err, "Error: Negative Balance");
            printErrorMessage(new PrintStream(new FileOutputStream("log.txt", true)), "Error: Negative Balance");
            return false;
        }
    }

    /**
     * Authenticates user's ssn
     * @param ssn                    The Account's ssn
     * @return                       true, if ssn equals Account's ssn, false otherwise
     * @throws FileNotFoundException if the log file not found
     */
    private boolean isSsnValid(String ssn) throws FileNotFoundException {
        if (ssn == null) {
            printErrorMessage(System.err, "Error: Invalid SSN");
            printErrorMessage(new PrintStream(new FileOutputStream("log.txt", true)), "Error: Invalid SSN");
            return false;
        }
        if (this.ssn == null) return false;
        if (!this.ssn.equals(ssn)) return false;

        return true;
    }

    /**
     * Prints an error message.
     * @param ps        the output print stream where the message lives
     * @param message   the message to print
     */
    private void printErrorMessage(PrintStream ps, String message) {
        if ((ps == null) || (message == null)) return;
        ps.println(message);
    }

    /**
     * Gets the balance's amount of money
     * @return the balance
     */
    public double getAccountBalance() {
        return getBalance();
    }

    /**
     * Gets the state of the account instance
     * @return the account state transformed to String
     */
    public String convertToString() {
        return "id: " + id + "\t" + "iban: " + iban + "\t" + "lastname: " + lastname
                + "\t" + "firstname: " + firstname + "\t" + "ssn: " + ssn
                +"\t" + "balance: " + balance;
    }

    /**
     * Prints the account state
     */
    public void printAccountState() {
        System.out.println("id: " + id + "\t" + "iban: " + iban + "\t" + "lastname: " + lastname
                + "\t" + "firstname: " + firstname + "\t" + "ssn: " + ssn
                +"\t" + "balance: " + balance);
    }
}
