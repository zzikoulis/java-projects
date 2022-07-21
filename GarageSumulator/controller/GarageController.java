package controller;

import dto.*;
import service.GarageServiceImpl;
import service.exceptions.FullGarageException;
import service.exceptions.PlateNumberAlreadyExistsException;
import service.exceptions.PlateNumberNotExistsException;
import service.exceptions.SpaceNotAvailableException;

import java.util.Date;

public class GarageController {

    GarageServiceImpl service = new GarageServiceImpl();

    public void vehicleEntranceController(int spaceNumber, String... fields) throws PlateNumberAlreadyExistsException, FullGarageException, SpaceNotAvailableException {

        ParkingSpotDTO dto = constructDTOFromInput(fields);

        service.vehicleEntranceService(spaceNumber, dto);
    }

    public double vehicleExitController(String plateNumber) throws PlateNumberNotExistsException {

        return service.vehicleExitService(plateNumber);
    }

    public int checkEmptySpacesNumberController() {
        return service.checkEmptySpacesNumberService();
    }

    public double showTotalMoneyController() {
        return service.showTotalMoneyService();
    }

    public String getStaffDetailsController(String plateNumber) throws PlateNumberNotExistsException {
        return service.getStaffDetailsService(plateNumber).toString().replace("DTO", "");
    }

    public String showEmptySpacesController() throws FullGarageException {
        return service.showEmptySpacesService();
    }

    private ParkingSpotDTO constructDTOFromInput(String... inputFields) {
        ParkingSpotDTO dto = new ParkingSpotDTO();

        DriverDTO driverDTO = new DriverDTO(inputFields[2], inputFields[3]);
        VehicleDTO vehicleDTO = (inputFields[1].equals("1")) ? new CarDTO(inputFields[0], driverDTO) : new MotorcycleDTO(inputFields[0], driverDTO);

        ParkingStaffDTO parkingStaffDTO = new ParkingStaffDTO(inputFields[4], inputFields[5]);

        dto.setVehicleDTO(vehicleDTO);
        dto.setParkingStaffDTO(parkingStaffDTO);
        dto.setEntranceTime(new Date());

        return dto;
    }
}
