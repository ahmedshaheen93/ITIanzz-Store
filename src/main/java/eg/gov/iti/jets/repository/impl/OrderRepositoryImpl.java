package eg.gov.iti.jets.repository.impl;

import eg.gov.iti.jets.model.*;
import eg.gov.iti.jets.repository.OrderRepository;

import java.util.Objects;
import java.util.Set;

public class OrderRepositoryImpl extends CrudImpl<Order, Long> implements OrderRepository {
    private static OrderRepositoryImpl instance;

    private OrderRepositoryImpl() {
    }

    public static synchronized OrderRepositoryImpl getInstance() {
        return Objects.requireNonNullElseGet(instance, () -> {
            instance = new OrderRepositoryImpl();
            return instance;
        });
    }

    @Override
    public Order createOrder(Order order, User user, Set<Purchase> purchaseSet, Double orderTotal) {
        getEntityManager().getTransaction().begin();
        user.addOrder(order);
        getEntityManager().persist(order);
        user.setBalance(user.getBalance() - orderTotal);
        purchaseSet.forEach(purchase -> {
            purchase.setOrderProductId(createOrderProductId(order, purchase));
            Product product = purchase.getProduct();
            product.setQuantity(product.getQuantity() - purchase.getQuantity());
            getEntityManager().persist(product);
            getEntityManager().persist(purchase);
            order.getPurchases().add(purchase);
        });
//        getEntityManager().createQuery(user);
        getEntityManager().getTransaction().commit();
        return order;
    }

    private OrderProductId createOrderProductId(Order order, Purchase purchase) {
        OrderProductId orderProductId = new OrderProductId();
        orderProductId.setOrderId(order.getOrderId());
        orderProductId.setProductId(purchase.getProduct().getProductId());
        return orderProductId;
    }
}
