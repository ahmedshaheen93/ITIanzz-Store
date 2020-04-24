package eg.gov.iti.jets.repository;

import eg.gov.iti.jets.model.Order;
import eg.gov.iti.jets.model.Purchase;
import eg.gov.iti.jets.model.User;

import java.util.Set;

public interface OrderRepository extends Crud<Order, Long> {
    Order createOrder(User user, Set<Purchase> purchaseSet, Double orderTotal);
}
