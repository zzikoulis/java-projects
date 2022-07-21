package dto;

public abstract class VehicleDTO {
    private String plateNumber;
    private DriverDTO driverDTO;

    public VehicleDTO(String plateNumber, DriverDTO driverDTO) {
        this.plateNumber = plateNumber;
        this.driverDTO = driverDTO;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public DriverDTO getDriver() {
        return driverDTO;
    }

}
