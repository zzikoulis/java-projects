package model;

public class Motorcycle extends Vehicle{

    public Motorcycle(String plateNumber, Driver driver) {
        super(plateNumber, driver, 3.0);
    }

    @Override
    public String toString() {
        return "Motorcycle's detail: \n" +
                "Plate Number: " + getPlateNumber() + "\n" +
                getDriver().toString() + "\n" +
                "Gets Credit: " + getCredit();
    }
}
