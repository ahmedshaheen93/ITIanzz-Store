package eg.gov.iti.jets.exception;

public class UserBalanceViolation extends Exception {
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
