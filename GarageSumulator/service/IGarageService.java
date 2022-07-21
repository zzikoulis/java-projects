package service;

import dto.ParkingSpotDTO;
import dto.ParkingStaffDTO;
import service.exceptions.FullGarageException;
import service.exceptions.PlateNumberAlreadyExistsException;
import service.exceptions.PlateNumberNotExistsException;
import service.exceptions.SpaceNotAvailableException;

public interface IGarageService {

    /**
     * Inserts at spaceNumber parking space a {@link model.ParkingSpot} based on the data carried by the {@link ParkingSpotDTO}
     * @param spaceNumber   the desirable parking space to insert
     * @param dto           DTO object that contains the data to be inserted
     * @throws PlateNumberAlreadyExistsException
     *                      if the plate number of the vehicle to be inserted has already been inserted
     * @throws FullGarageException
     *                      if there are no available spaces
     * @throws SpaceNotAvailableException
     *                      if the desirable parking space to insert is already full
     */
    void vehicleEntranceService(int spaceNumber, ParkingSpotDTO dto) throws PlateNumberAlreadyExistsException, FullGarageException, SpaceNotAvailableException;


    /**
     * Exits a {@link model.ParkingSpot} from the garage based on the plate number of the vehicle to be exited
     * @param plateNumber   the plate number of the vehicle to be exited
     * @return              the parking cost
     * @throws PlateNumberNotExistsException
     *                      if the plate number of the vehicle to be exited not exists in the garage
     */
    double vehicleExitService(String plateNumber) throws PlateNumberNotExistsException;


    /**
     * Checks the current number of the available and empty spaces in the garage
     * @return the current number of the available and empty spaces in the garage
     */
    int checkEmptySpacesNumberService();


    /**
     * Shows what space numbers are available in the garage.
     * the format is: ( 0 ) ( 1 ) ( 2 ) etc.
     * @throws FullGarageException
     *      if there are no available spaces
     */
    String showEmptySpacesService() throws FullGarageException;


    /**
     * Shows the total money earned by now
     * @return the total money earned by now
     */
    double showTotalMoneyService();


    /**
     * Shows the firstname and lastname of the Parking Staff that parked a vehicle based on the plate number
     * @param plateNumber the plate number of the relevant vehicle
     * @return  a {@link dto.ParkingStaffDTO} object that contains the firstname and lastname of the Parking Staff that parked the vehicle
     * @throws PlateNumberNotExistsException
     *      if the plate number of the vehicle not exists in the garage
     */
    ParkingStaffDTO getStaffDetailsService(String plateNumber) throws PlateNumberNotExistsException;
}
