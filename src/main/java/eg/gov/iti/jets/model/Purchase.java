package eg.gov.iti.jets.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PURCHASES")
public class Purchase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long purchaseId;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "PRODUCT_BUY_PRICE")
    private double productBuyPrice;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public Purchase() {
    }

    public Purchase(int quantity, double productBuyPrice, Order order, Product product) {
        this.quantity = quantity;
        this.productBuyPrice = productBuyPrice;
        this.order = order;
        this.product = product;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}