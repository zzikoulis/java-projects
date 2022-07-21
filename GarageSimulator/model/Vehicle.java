package model;

public abstract class Vehicle {
    private String plateNumber;
    private Driver driver;
    private double chargePerHour;
    private boolean credit;

    public Vehicle(String plateNumber, Driver driver, double chargePerHour) {
        this.plateNumber = plateNumber;
        this.driver = driver;
        this.chargePerHour = chargePerHour;
        this.credit = false;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public double getChargePerHour() {
        return chargePerHour;
    }

    public void setChargePerHour(double chargePerHour) {
        this.chargePerHour = chargePerHour;
    }

    public boolean getCredit() {
        return credit;
    }

    public void setCredit(boolean credit) {
        this.credit = credit;
    }
}
