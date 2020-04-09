package eg.gov.iti.jets.service.impl;

import eg.gov.iti.jets.exception.ProductQuantityLimitExceeded;
import eg.gov.iti.jets.exception.UserBalanceViolation;
import eg.gov.iti.jets.model.Order;
import eg.gov.iti.jets.model.Purchase;
import eg.gov.iti.jets.model.User;
import eg.gov.iti.jets.repository.OrderRepository;
import eg.gov.iti.jets.repository.impl.OrderRepositoryImpl;
import eg.gov.iti.jets.service.OrderService;
import eg.gov.iti.jets.service.UserService;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class OrderServiceImpl implements OrderService {

    private static OrderServiceImpl instance;
    private UserService userService;
    private OrderRepository orderRepository;

    protected OrderServiceImpl() {
        userService = UserServiceImpl.getInstance();
        orderRepository = OrderRepositoryImpl.getInstance();
        System.err.println("orderRepository >>>>>>>>>>>>>>>>" + orderRepository);
    }

    public static synchronized OrderServiceImpl getInstance() {
        return Objects.requireNonNullElseGet(instance,
                () -> {
                    instance = new OrderServiceImpl();
                    return instance;
                });

    }

    @Override
    public synchronized Order createOrder(User user, Set<Purchase> purchases)
            throws UserBalanceViolation, ProductQuantityLimitExceeded {
        orderRepository = OrderRepositoryImpl.getInstance();
        System.err.println("orderRepository >>>>>>>>>>>>>>>>" + orderRepository);
        AtomicReference<Double> orderTotalMoney = getTotalOfOrder(purchases);
        System.err.println(user.getBalance());
        if (user.getBalance() < orderTotalMoney.get()) {
            throw new UserBalanceViolation();
        }
        if (!checkIfIsStockEnough(purchases)) {
            throw new ProductQuantityLimitExceeded();
        }

        Order order = createNewOder(user, purchases);
        System.err.println(-orderTotalMoney.get());
        userService.addUserBalance(user, -orderTotalMoney.get());
        return orderRepository.createOrder(order, user, purchases);
    }

    private AtomicReference<Double> getTotalOfOrder(Set<Purchase> purchases) {
        AtomicReference<Double> orderTotalMoney = new AtomicReference<>(0d);
        purchases.forEach((purchase ->
                orderTotalMoney.updateAndGet(oldTotal ->
                        oldTotal += (purchase.getProductBuyPrice() * purchase.getQuantity()))));
        return orderTotalMoney;
    }

    private Boolean checkIfIsStockEnough(Set<Purchase> purchases) {
        AtomicBoolean isAvailable = new AtomicBoolean(true);
        purchases.forEach(purchase -> {
            if (purchase.getProduct().getQuantity() < purchase.getQuantity())
                isAvailable.set(false);
        });
        return isAvailable.get();
    }

    private Order createNewOder(User user, Set<Purchase> purchases) {
        Order order = new Order();
        order.setOrderTimestamp(LocalDateTime.now());
//        order.getPurchases().addAll(purchases);
//        order.setUser(user);
//        user.getOrders().add(order);
        return order;
    }
}
