package service.exceptions;

public class FullGarageException extends Exception {
    private static final long serialVersionUID = 1L;

    public FullGarageException() {
        super("Garage is full! Operation can not be done.");
    }

}
