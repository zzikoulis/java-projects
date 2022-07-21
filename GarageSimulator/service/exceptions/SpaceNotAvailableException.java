package service.exceptions;

public class SpaceNotAvailableException extends Exception{

    private static final long serialVersionUID = 1L;

    public SpaceNotAvailableException(int spaceNumber) {
        super("Space with number: " + spaceNumber + " is not available. Operation can not be done.");
    }
}
