package eg.gov.iti.jets.model.dto;

import java.util.HashSet;
import java.util.Set;

public class ProductDto {
    private Long productId;
    private String productName;
    private String description;
    private String manufacturingName;
    private String manufacturingDate;
    private String expirationDate;
    private int quantity;
    private Set<String> categories = new HashSet<>(0);
    private String price;
    private String primaryImage;
    private Set<String> images = new HashSet<>(0);

    public ProductDto(Long productId, String productName, String description, String manufacturingName, String manufacturingDate, String expirationDate, int quantity, Set<String> categories, String price, String primaryImage, Set<String> images) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.manufacturingName = manufacturingName;
        this.manufacturingDate = manufacturingDate;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
        this.categories = categories;
        this.price = price;
        this.primaryImage = primaryImage;
        this.images = images;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturingName() {
        return manufacturingName;
    }

    public void setManufacturingName(String manufacturingName) {
        this.manufacturingName = manufacturingName;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrimaryImage() {
        return primaryImage;
    }

    public void setPrimaryImage(String primaryImage) {
        this.primaryImage = primaryImage;
    }

    public Set<String> getImages() {
        return images;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", manufacturingName='" + manufacturingName + '\'' +
                ", manufacturingDate='" + manufacturingDate + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", quantity=" + quantity +
                ", categories=" + categories +
                ", price='" + price + '\'' +
                ", primaryImage='" + primaryImage + '\'' +
                ", images=" + images +
                '}';
    }
}
