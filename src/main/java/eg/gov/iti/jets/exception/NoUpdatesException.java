package eg.gov.iti.jets.exception;

public class NoUpdatesException extends Exception {

    private String message = "you did not make any updates..";

    public NoUpdatesException() {
        super();
    }

    public NoUpdatesException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}