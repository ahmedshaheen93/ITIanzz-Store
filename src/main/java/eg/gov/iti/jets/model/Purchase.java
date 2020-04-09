package eg.gov.iti.jets.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PURCHASES")
public class Purchase implements Serializable {

    private static final long serialVersionUID = -1464490210399240971L;

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "orderId", column = @Column(name = "ORDER_ID", nullable = false)),
            @AttributeOverride(name = "productId", column = @Column(name = "PRODUCT_ID", nullable = false))})
    private OrderProductId orderProductId;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "PRODUCT_BUY_PRICE")
    private double productBuyPrice;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID", nullable = false, insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", nullable = false, insertable = false, updatable = false)
    private Product product;

    public Purchase() {
    }

    public Purchase(int quantity, double productBuyPrice, Product product) {
        this.quantity = quantity;
        this.productBuyPrice = productBuyPrice;
        this.product = product;
    }

    public OrderProductId getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(OrderProductId orderProductId) {
        this.orderProductId = orderProductId;
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