package service.exceptions;

public class PlateNumberAlreadyExistsException extends Exception {

    private static final long serialVersionUID = 1L;

    public PlateNumberAlreadyExistsException(String plateNumber) {
        super("Vehicle with plate number: '" + plateNumber + "' already exists. Operation can not be done.");
    }
}
