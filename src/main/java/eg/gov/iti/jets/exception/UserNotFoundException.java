package eg.gov.iti.jets.exception;

public class UserNotFoundException extends Exception {

    private static final long serialVersionUID = 2376211640570036734L;

    private String message = "User not found on the database , check entered data";

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
