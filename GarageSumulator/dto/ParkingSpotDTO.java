package dto;

import java.util.Date;

public class ParkingSpotDTO {
    private VehicleDTO vehicleDTO;
    private ParkingStaffDTO parkingStaffDTO;
    private Date entranceTime;

    public ParkingSpotDTO() {}

    public VehicleDTO getVehicleDTO() {
        return vehicleDTO;
    }

    public void setVehicleDTO(VehicleDTO vehicleDTO) {
        this.vehicleDTO = vehicleDTO;
    }

    public ParkingStaffDTO getParkingStaffDTO() {
        return parkingStaffDTO;
    }

    public void setParkingStaffDTO(ParkingStaffDTO parkingStaffDTO) {
        this.parkingStaffDTO = parkingStaffDTO;
    }

    public Date getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(Date entranceTime) {
        this.entranceTime = entranceTime;
    }

}
