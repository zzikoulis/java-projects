package dao;

import model.Driver;
import model.ParkingSpot;
import model.ParkingStaff;

public interface IGarageDAO {
    /**
     * Inserts a {@link ParkingSpot} object at available number space
     * @param spaceNumber empty space number to insert (service layer has already checked the space's availability)
     * @param parkingSpot {@link ParkingSpot} object to be inserted
     */
    void insertGarage(int spaceNumber, ParkingSpot parkingSpot);

    /**
     * Exits a {@link ParkingSpot} object from the garage and returns the relevant parking cost.
     * Parking cost is free of charge for the first 30 minutes (returns 0.0)
     * If a driver has more than 1 vehicle in the garage, then each of it has a credit of 30% of the vehicle's
     * parking cost.
     * @param exitPosition space number to empty
     * @return  the parking cost of the vehicle that exited
     */
    ParkingSpot exitGarage(int exitPosition);

    /**
     * Checks and returns the number of the current empty spaces in the garage
     * @return  the current empty spaces in the garage
     */
    int checkEmptySpacesNumber();

    /**
     * Shows the total money earned by now
     * @return  the total money earned by now
     */
    double showTotalMoney();

    /**
     * Returns a {@link ParkingStaff} object contains the details of the parking staff that parked a vehicle based on the plate number
     * @param plateNumber the plate number of the relevant vehicle
     * @return a {@link ParkingStaff} object contains the details of the parking staff that parked the vehicle, otherwise returns null
     */
    ParkingStaff getStaffDetails(String plateNumber);

    /**
     * Checks if a plate number exists in the garage
     * @param plateNumber   the plate number to be found
     * @return  if a plate number exists in the garage
     */
    boolean findIfPlateNumberExists(String plateNumber);

    /**
     * Returns the space number of a vehicle in the garage based on the plate number
     * @param plateNumber   the plate number of the relevant vehicle
     * @return  the space number of the vehicle in the garage (if exists), otherwise -1
     */
    int findPlateNumberPosition(String plateNumber);

    /**
     * Checks if a driver has already a vehicle in the garage, before insert a new one.
     * If true then it sets a credit to that vehicle in order to compute the credit of the parking cost at the exit of the vehicle.
     * Check for an already inserted vehicle is done by the {@link Driver} firstname and lastname
     * @param driver {@link Driver} object to check if it has other vehicles in the garage
     * @return  true if driver has other vehicles in the garage and gets a credit, otherwise false
     */
    boolean checkForCreditAndUpdate(Driver driver);

    /**
     * Adds the parking cost at the exit of every vehicle to the total money earned
     * @param amount the parking cost to be added to the total money earned
     */
    void addToTotalMoney (double amount);

    /**
     * Shows what space numbers are available in the garage.
     * the format is: ( 0 ) ( 1 ) ( 2 ) etc.
     * If there are no empty spaces, returns null
     */
    String showEmptySpaces();

    /**
     * Checks if a space is empty or not
     * @param spaceNumber the space number to be checked
     * @return if a space is empty or not
     */
    boolean isSpaceEmpty(int spaceNumber);
}
