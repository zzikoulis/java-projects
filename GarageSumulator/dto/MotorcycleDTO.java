package dto;

public class MotorcycleDTO extends VehicleDTO{

    public MotorcycleDTO(String plateNumber, DriverDTO driverDTO) {
        super(plateNumber, driverDTO);
    }

    @Override
    public String toString() {
        return "MotorcycleDTO's detail: \n" +
                "Plate Number: " + getPlateNumber() + "\n" +
                getDriver().toString() + "\n";
    }
}
