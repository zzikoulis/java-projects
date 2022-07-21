package dao;

import model.Driver;
import model.ParkingSpot;
import model.ParkingStaff;

public class GarageDAOImpl implements IGarageDAO {
    private static final GarageDAOImpl DAO = new GarageDAOImpl();
    private static final int GARAGE_SIZE = 100;
    private static int emptySpaces = GARAGE_SIZE;
    private static double totalMoney = 0.0;

    private static final ParkingSpot[] garage = new ParkingSpot[GARAGE_SIZE];

    private GarageDAOImpl() {}

    public static GarageDAOImpl getInstance() { return DAO;}

    @Override
    public void insertGarage(int spaceNumber, ParkingSpot parkingSpot) {
        garage[spaceNumber] = parkingSpot;
        emptySpaces--;
    }

    @Override
    public ParkingSpot exitGarage(int exitPosition) {
        ParkingSpot parkingSpot = garage[exitPosition];
        garage[exitPosition] = null;
        emptySpaces++;

        return parkingSpot;
    }

    @Override
    public int checkEmptySpacesNumber() {
        return emptySpaces;
    }

    @Override
    public double showTotalMoney() {
        return totalMoney;
    }

    @Override
    public ParkingStaff getStaffDetails(String plateNumber) {
        for (ParkingSpot parkingSpot : garage) {
            if ((parkingSpot != null) && (parkingSpot.getVehicle().getPlateNumber().equals(plateNumber))) {
                return parkingSpot.getParkingStaff();
            }
        }
        return null;
    }

    @Override
    public boolean findIfPlateNumberExists(String plateNumber) {
        for (ParkingSpot parkingSpot : garage) {
            if ((parkingSpot != null) && parkingSpot.getVehicle().getPlateNumber().equals(plateNumber)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int findPlateNumberPosition(String plateNumber) {
        for (int i = 0; i < GARAGE_SIZE; i++) {
            if ((garage[i] != null) && garage[i].getVehicle().getPlateNumber().equals(plateNumber)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean checkForCreditAndUpdate(Driver driver) {
        for (ParkingSpot parkingSpot : garage) {

            if ((parkingSpot != null) && (parkingSpot.getVehicle().getDriver().getFirstname().equals(driver.getFirstname()))
                                      && (parkingSpot.getVehicle().getDriver().getLastname().equals(driver.getLastname()))) {

                parkingSpot.getVehicle().setCredit(true);
                return true;
            }
        }

        return false;
    }

    @Override
    public void addToTotalMoney (double amount) {
        totalMoney += amount;
    }

    @Override
    public String showEmptySpaces() {
        String emptySpaces = "";
        int counter = 0;

        for (int i = 0; i < GARAGE_SIZE; i++) {
            if (garage[i] == null) {
                emptySpaces = emptySpaces.concat("( ").concat(String.valueOf(i)).concat(" ) ");
                if (++counter % 10 == 0)
                    emptySpaces = emptySpaces.concat("\n");
            }
        }

        return emptySpaces.equals("") ? null : emptySpaces;
    }

    @Override
    public boolean isSpaceEmpty(int spaceNumber) {
        if ((spaceNumber < 0) || (spaceNumber >= GARAGE_SIZE))
            return false;

        return (garage[spaceNumber] == null);
    }
}
