package model;

public class Car extends Vehicle{

    public Car(String plateNumber, Driver driver) {
        super(plateNumber, driver, 5.0);
    }

    @Override
    public String toString() {
        return "Car's detail: \n" +
                "Plate Number: " + getPlateNumber() + "\n" +
                getDriver().toString() + "\n" +
                "Gets Credit: " + getCredit();
    }
}
