package dto;

public class CarDTO extends VehicleDTO{

    public CarDTO(String plateNumber, DriverDTO driverDTO) {
        super(plateNumber, driverDTO);
    }

    @Override
    public String toString() {
        return "CarDTO's detail: \n" +
                "Plate Number: " + getPlateNumber() + "\n" +
                getDriver().toString() + "\n";
    }
}
