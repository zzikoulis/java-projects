package model;

public class ParkingStaff {
    private String firstname;
    private String lastname;

    public ParkingStaff(String firstname, String lastname) {
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
        return "ParkingStaff's " +
                "firstname is: '" + firstname + "' " +
                "and lastname is: '" + lastname + "'\n";
    }
}
