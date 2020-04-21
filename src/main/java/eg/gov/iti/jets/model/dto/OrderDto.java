package eg.gov.iti.jets.model.dto;

import java.util.HashSet;
import java.util.Set;

public class OrderDto {
    private Long orderId;
    private String orderTimestamp;
    private Set<PurchaseDto> purchases = new HashSet<>(0);


    public OrderDto(Long orderId, String orderTimestamp,
                    Set<PurchaseDto> purchases) {
        this.orderId = orderId;
        this.orderTimestamp = orderTimestamp;
        this.purchases = purchases;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderTimestamp() {
        return orderTimestamp;
    }

    public void setOrderTimestamp(String orderTimestamp) {
        this.orderTimestamp = orderTimestamp;
    }

    public Set<PurchaseDto> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<PurchaseDto> purchases) {
        this.purchases = purchases;
    }

}
