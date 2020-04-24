package eg.gov.iti.jets.utilty;

import eg.gov.iti.jets.model.Order;
import eg.gov.iti.jets.model.Purchase;
import eg.gov.iti.jets.model.dto.OrderDto;
import eg.gov.iti.jets.model.dto.PurchaseDto;
import eg.gov.iti.jets.service.OrderService;
import eg.gov.iti.jets.service.impl.OrderServiceImpl;

import java.util.HashSet;
import java.util.Set;

public class OrderMapper {
    private static OrderService orderService = OrderServiceImpl.getInstance();
    public static OrderDto mapOrder(Order order) {
        Set<PurchaseDto> purchases = new HashSet<>();
        for (Purchase purchase : order.getPurchases()) {
            purchases.add(PurchaseMapper.mapPurchase(purchase));
        }
        return new OrderDto(order.getOrderId(), order.getOrderTimestamp().toString(), purchases);
    }

    public static Order mapOrder(OrderDto orderDto) {
        return orderService.findById(orderDto.getOrderId());
    }

}
