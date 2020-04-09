package eg.gov.iti.jets.exception;

public class UserBalanceViolation extends Exception {

    private static final long serialVersionUID = 7091749928971452306L;

    private String message = "this Amount of money larger than user balance , check entered data";

    public UserBalanceViolation() {
        super();
    }

    public UserBalanceViolation(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
