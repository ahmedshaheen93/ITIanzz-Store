package eg.gov.iti.jets.exception;

public class ProductQuantityLimitExceeded extends Exception {
    private String message = "this Quantity larger than Product Quantity on the store , check entered data";

    public ProductQuantityLimitExceeded() {
        super();
    }

    public ProductQuantityLimitExceeded(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
