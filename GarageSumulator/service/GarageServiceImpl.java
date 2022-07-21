package service;

import dao.GarageDAOImpl;
import dto.CarDTO;
import dto.ParkingSpotDTO;
import dto.ParkingStaffDTO;
import model.*;
import service.exceptions.FullGarageException;
import service.exceptions.PlateNumberAlreadyExistsException;
import service.exceptions.PlateNumberNotExistsException;
import service.exceptions.SpaceNotAvailableException;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class GarageServiceImpl implements IGarageService {

    GarageDAOImpl dao = GarageDAOImpl.getInstance();

    @Override
    public void vehicleEntranceService(int spaceNumber, ParkingSpotDTO dto) throws PlateNumberAlreadyExistsException, FullGarageException, SpaceNotAvailableException {
        ParkingSpot parkingSpot = new ParkingSpot();
        extractFieldsFromDTO(dto, parkingSpot);

        if(!dao.isSpaceEmpty(spaceNumber)) {
            throw new SpaceNotAvailableException(spaceNumber);
        }

        if(dao.findIfPlateNumberExists(parkingSpot.getVehicle().getPlateNumber())) {
            throw new PlateNumberAlreadyExistsException(parkingSpot.getVehicle().getPlateNumber());
        }

        if (dao.checkEmptySpacesNumber() == 0) {
            throw new FullGarageException();
        }

        if (dao.checkForCreditAndUpdate(parkingSpot.getVehicle().getDriver())) {
            parkingSpot.getVehicle().setCredit(true);
        }

        dao.insertGarage(spaceNumber, parkingSpot);
    }

    @Override
    public double vehicleExitService(String plateNumber) throws PlateNumberNotExistsException {
        int exitPosition;
        ParkingSpot parkingSpot;
        long minutes;
        boolean credit;
        double chargePerHour;
        double parkingCost;

        exitPosition = dao.findPlateNumberPosition(plateNumber);
        if (exitPosition == -1) {
            throw new PlateNumberNotExistsException(plateNumber);
        }

        parkingSpot = dao.exitGarage(exitPosition);

        minutes = TimeUnit.MILLISECONDS.toMinutes(new Date().getTime() - parkingSpot.getEntranceTime().getTime());
        credit = parkingSpot.getVehicle().getCredit();
        chargePerHour = parkingSpot.getVehicle().getChargePerHour();

        if (minutes < 31) {
            return 0.0;
        }

        parkingCost = (credit) ? (chargePerHour * (minutes/60.0) * 0.7)
                : (chargePerHour * (minutes/60.0));
        dao.addToTotalMoney(parkingCost);
        return parkingCost;
    }

    @Override
    public int checkEmptySpacesNumberService() {
        return dao.checkEmptySpacesNumber();
    }

    @Override
    public String showEmptySpacesService() throws FullGarageException {
        String emptySpaces = dao.showEmptySpaces();

        if (emptySpaces == null) {
            throw new FullGarageException();
        }

        return emptySpaces;
    }

    @Override
    public double showTotalMoneyService() {
        return dao.showTotalMoney();
    }

    @Override
    public ParkingStaffDTO getStaffDetailsService(String plateNumber) throws PlateNumberNotExistsException {
        ParkingStaff parkingStaff;
        parkingStaff = dao.getStaffDetails(plateNumber);

        if (parkingStaff == null) {
            throw new PlateNumberNotExistsException(plateNumber);
        }

        return new ParkingStaffDTO(parkingStaff.getFirstname(), parkingStaff.getLastname());
    }

    private void extractFieldsFromDTO(ParkingSpotDTO dto, ParkingSpot parkingSpot) {

        Driver driver = new Driver(dto.getVehicleDTO().getDriver().getFirstname(), dto.getVehicleDTO().getDriver().getLastname());
        Vehicle vehicle = (dto.getVehicleDTO() instanceof CarDTO) ?  new Car(dto.getVehicleDTO().getPlateNumber(), driver) : new Motorcycle(dto.getVehicleDTO().getPlateNumber(), driver);

        ParkingStaff parkingStaff = new ParkingStaff(dto.getParkingStaffDTO().getFirstname(), dto.getParkingStaffDTO().getLastname());

        parkingSpot.setVehicle(vehicle);
        parkingSpot.setParkingStaff(parkingStaff);
        parkingSpot.setEntranceTime(dto.getEntranceTime());
    }

}
