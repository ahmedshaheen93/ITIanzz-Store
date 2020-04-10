package eg.gov.iti.jets.model.dto;

public class ProductSearchExampleDTO {
    private Long categoryId;
    private int min;
    private int max;
    private String productName;

    public ProductSearchExampleDTO() {
    }

    @Override
    public String toString() {
        return "ProductSearchExampleDTO{" +
                "categoryId=" + categoryId +
                ", min=" + min +
                ", max=" + max +
                ", productName='" + productName + '\'' +
                '}';
    }

    public ProductSearchExampleDTO(Long categoryId, int min, int max, String productName) {
        this.categoryId = categoryId;
        this.min = min;
        this.max = max;
        this.productName = productName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
