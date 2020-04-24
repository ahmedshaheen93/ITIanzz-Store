package eg.gov.iti.jets.service.impl;

import eg.gov.iti.jets.exception.ProductQuantityLimitExceeded;
import eg.gov.iti.jets.exception.UserBalanceViolation;
import eg.gov.iti.jets.model.Order;
import eg.gov.iti.jets.model.Purchase;
import eg.gov.iti.jets.model.User;
import eg.gov.iti.jets.model.dto.UserDto;
import eg.gov.iti.jets.repository.OrderRepository;
import eg.gov.iti.jets.repository.impl.OrderRepositoryImpl;
import eg.gov.iti.jets.service.OrderService;
import eg.gov.iti.jets.service.UserService;
import eg.gov.iti.jets.utilty.UserMapper;

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
    public synchronized Order createOrder(UserDto userDto, Set<Purchase> purchases)
            throws UserBalanceViolation, ProductQuantityLimitExceeded {
        AtomicReference<Double> orderTotalMoney = getTotalOfOrder(purchases);

        System.err.println(userDto.getBalance());

        if (userDto.getBalance() < orderTotalMoney.get()) {
            throw new UserBalanceViolation();
        }
        if (!checkIfIsStockEnough(purchases)) {
            throw new ProductQuantityLimitExceeded();
        }

        Order order = createNewOder();
        System.err.println(-orderTotalMoney.get());
        User user = UserMapper.mapUser(userDto);
        order = orderRepository.createOrder(order, user, purchases, orderTotalMoney.get());
        return order;
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id);
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

    private Order createNewOder() {
        Order order = new Order();
        order.setOrderTimestamp(LocalDateTime.now());
        return order;
    }
}
