package eg.gov.iti.jets.service;

import eg.gov.iti.jets.exception.ProductQuantityLimitExceeded;
import eg.gov.iti.jets.exception.UserBalanceViolation;
import eg.gov.iti.jets.model.Order;
import eg.gov.iti.jets.model.Purchase;
import eg.gov.iti.jets.model.User;

import java.util.Set;

public interface OrderService {

    Order createOrder(User user, Set<Purchase> purchases) throws UserBalanceViolation
            , ProductQuantityLimitExceeded;
}
