package service.exceptions;

public class PlateNumberNotExistsException extends Exception{

    private static final long serialVersionUID = 1L;

    public PlateNumberNotExistsException(String plateNumber) {
        super("Vehicle with plate number: '" + plateNumber + "' does not exists. Operation can not be done.");
    }
}
