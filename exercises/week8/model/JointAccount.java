package exercises.week8.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class JointAccount {
    private long id;
    private String iban;
    private String lastname1;
    private String firstname1;
    private String ssn1;
    private String lastname2;
    private String firstname2;
    private String ssn2;
    private double balance;

    public static JointAccount getInstance() {
        return new JointAccount();
    }

    private JointAccount() {}

    public JointAccount(long id, String iban, String lastname1, String firstname1, String ssn1, String lastname2, String firstname2, String ssn2, double balance) {
        this.id = id;
        this.iban = iban;
        this.lastname1 = lastname1;
        this.firstname1 = firstname1;
        this.ssn1 = ssn1;
        this.lastname2 = lastname2;
        this.firstname2 = firstname2;
        this.ssn2 = ssn2;
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

    public String getLastname1() {
        return lastname1;
    }

    public void setLastname1(String lastname1) {
        this.lastname1 = lastname1;
    }

    public String getFirstname1() {
        return firstname1;
    }

    public void setFirstname1(String firstname1) {
        this.firstname1 = firstname1;
    }

    public String getSsn1() {
        return ssn1;
    }

    public void setSsn1(String ssn1) {
        this.ssn1 = ssn1;
    }

    public String getLastname2() {
        return lastname2;
    }

    public void setLastname2(String lastname2) {
        this.lastname2 = lastname2;
    }

    public String getFirstname2() {
        return firstname2;
    }

    public void setFirstname2(String firstname2) {
        this.firstname2 = firstname2;
    }

    public String getSsn2() {
        return ssn2;
    }

    public void setSsn2(String ssn2) {
        this.ssn2 = ssn2;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


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


        if(amount <= balance) {
            balance -= amount;
            return true;
        } else {
            printErrorMessage(System.err, "Error: Insufficient Balance");
            printErrorMessage(new PrintStream(new FileOutputStream("log.txt", true)), "Error: Insufficient Balance");
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
        if ((this.ssn1 == null) && (this.ssn2 == null)) {
            return false;
        } else if ((this.ssn1 != null) && (this.ssn2 == null)) {
            return this.ssn1.equals(ssn);
        } else if (this.ssn1 == null) {
            return this.ssn2.equals(ssn);
        } else {
            return (this.ssn1.equals(ssn) || this.ssn2.equals(ssn));
        }
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
        return "id: " + id + "\t" + "iban: " + iban + "\t" + "lastname1: " + lastname1
                + "\t" + "firstname1: " + firstname1 + "\t" + "ssn1: " + ssn1 + "\t"
                + "lastname2: " + lastname2 + "\t" + "firstname2: " + firstname2 + "\t"
                + "ssn2: " + ssn2 +"\t" + "balance: " + balance;
    }

    /**
     * Prints the account state
     */
    public void printAccountState() {
        System.out.println("id: " + id + "\t" + "iban: " + iban + "\t" + "lastname1: " + lastname1
                + "\t" + "firstname1: " + firstname1 + "\t" + "ssn1: " + ssn1 + "\t"
                + "lastname2: " + lastname2 + "\t" + "firstname2: " + firstname2 + "\t"
                + "ssn2: " + ssn2 +"\t" + "balance: " + balance);
    }
}
