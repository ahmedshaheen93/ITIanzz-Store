package eg.gov.iti.jets.exception;

public class ProductQuantityLimitExceeded extends Exception {
    
    private static final long serialVersionUID = 8358698252443245743L;
    
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
