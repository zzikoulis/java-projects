package model;

import java.util.Date;

public class ParkingSpot {
    private Vehicle vehicle;
    private ParkingStaff parkingStaff;
    private Date entranceTime;

    public ParkingSpot() {}

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingStaff getParkingStaff() {
        return parkingStaff;
    }

    public void setParkingStaff(ParkingStaff parkingStaff) {
        this.parkingStaff = parkingStaff;
    }

    public Date getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(Date entranceTime) {
        this.entranceTime = entranceTime;
    }

}
