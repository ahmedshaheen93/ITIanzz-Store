package eg.gov.iti.jets.repository.impl;

import eg.gov.iti.jets.model.*;
import eg.gov.iti.jets.repository.OrderRepository;

import java.time.LocalDateTime;
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
    public Order createOrder(User user, Set<Purchase> purchaseSet, Double orderTotal) {
        System.out.println("createOrder ****************************" + user.getOrders().size());
        System.out.println("createOrder ****************************" + user.getBalance());
        Order order = new Order();
        order.setOrderTimestamp(LocalDateTime.now());

        getEntityManager().getTransaction().begin();
        user.addOrder(order);
        user.setBalance(user.getBalance() - orderTotal);
        getEntityManager().persist(order);

        purchaseSet.forEach(purchase -> {
            purchase.setOrderProductId(createOrderProductId(order, purchase));
            Product product = purchase.getProduct();
            product.setQuantity(product.getQuantity() - purchase.getQuantity());
            getEntityManager().persist(product);
            getEntityManager().persist(purchase);
            order.getPurchases().add(purchase);
        });
        getEntityManager().getTransaction().commit();
        System.out.println("createOrder ****************************" + user.getOrders().size());
        System.out.println("createOrder ****************************" + user.getBalance());
        User byId = UserRepositoryImpl.getInstance().findById(user.getUserId());
        System.out.println("from db ****************************" + byId.getOrders().size());
        System.out.println("from db ****************************" + byId.getBalance());

        return order;
    }

    private OrderProductId createOrderProductId(Order order, Purchase purchase) {
        OrderProductId orderProductId = new OrderProductId();
        orderProductId.setOrderId(order.getOrderId());
        orderProductId.setProductId(purchase.getProduct().getProductId());
        return orderProductId;
    }
}
