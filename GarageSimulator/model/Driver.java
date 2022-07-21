package model;

public class Driver {
    private String firstname;
    private String lastname;

    public Driver(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Driver's " +
                "firstname is: '" + firstname + "' " +
                "and lastname is: '" + lastname + "'\n";
    }
}
