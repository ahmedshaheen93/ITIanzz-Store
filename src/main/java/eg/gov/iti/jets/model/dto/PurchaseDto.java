package eg.gov.iti.jets.model.dto;

public class PurchaseDto {
    private int quantity;
    private double productBuyPrice;
    private ProductDto product;

    public PurchaseDto(int quantity, double productBuyPrice, ProductDto product) {
        this.quantity = quantity;
        this.productBuyPrice = productBuyPrice;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getProductBuyPrice() {
        return productBuyPrice;
    }

    public void setProductBuyPrice(double productBuyPrice) {
        this.productBuyPrice = productBuyPrice;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }
}
