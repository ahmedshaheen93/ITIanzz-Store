package eg.gov.iti.jets.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PRODUCTS")
@NamedQueries({
        @NamedQuery(name = "Product.findByNameLike",
                query = "SELECT p from Product p where p.productName like :productName"),
        @NamedQuery(name = "Product.findByCategory",
                query = "SELECT p from Product p where :category member of p.categories"),
        @NamedQuery(name = "Product.findBetweenTwoPrices",
                query = "SELECT p from Product  p where p.sellPrice between :price1 and :price2"),
        @NamedQuery(name = "Product.findByCategoryAndMinMaxPriceAndProductName",
                query = "SELECT p from Product  p where p.sellPrice between :price1 and :price2" +
                        " and :category member of p.categories" +
                        " and p.productName like :productName")
})
public class Product implements Serializable {

    private static final long serialVersionUID = 7348482741530204791L;

    /**
     * product id is a unique identifier for the product that Generated automatic by
     * jpa framework
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;
    /**
     * product name is a name for the product
     * that user can search with
     */
    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;
    /**
     * product description for user
     * accept null value
     */
    @Column(name = "PRODUCT_DESCRIPTION", length = 5000)
    private String description;
    /**
     * manufacturingName represent where does the product manufacture
     * accept null value
     */
    @Column(name = "PRODUCT_MANUFACTURE")
    private String manufacturingName;
    /**
     * manufacturingDate represent when does the product manufacture
     * does not accept null value
     */
    @Column(name = "PRODUCT_MANUFACTURING_DATE", nullable = false)
    private LocalDate manufacturingDate;
    /**
     * expirationDate represent when does the product expire
     * accept null value
     */
    @Column(name = "PRODUCT_EXPIRATION_DATE")
    private LocalDate expirationDate;
    /**
     * quantity  represent current product quantity
     * does not accept null value
     */
    @Column(name = "PRODUCT_QUANTITY", nullable = false)
    private int quantity;

    @ManyToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH}
            , fetch = FetchType.LAZY)
    @JoinTable(
            name = "PRODUCT_CATEGORIES",
            joinColumns = @JoinColumn(name = "PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID")
    )
    private Set<Category> categories = new HashSet<>(0);

    @Column(name = "PRODUCT_BUY_PRICE", nullable = false)
    private Double buyPrice;

    @Column(name = "PRODUCT_SELL_PRICE", nullable = false)
    private Double sellPrice;

    @OneToOne
    @JoinColumn(name = "IMAGE_ID", nullable = false)
    private Image primaryImage;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Image> images;

    public Product() {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Image getPrimaryImage() {
        return primaryImage;
    }

    public void setPrimaryImage(Image primaryImage) {
        this.primaryImage = primaryImage;
    }

    public Set<Image> getImages() {
        return Objects.requireNonNullElseGet(images, () -> {
                    images = new HashSet<>(0);
                    return images;
                }
        );
    }

}
