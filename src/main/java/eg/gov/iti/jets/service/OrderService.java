package eg.gov.iti.jets.service;

import eg.gov.iti.jets.exception.ProductQuantityLimitExceeded;
import eg.gov.iti.jets.exception.UserBalanceViolation;
import eg.gov.iti.jets.model.Order;
import eg.gov.iti.jets.model.Purchase;
import eg.gov.iti.jets.model.dto.UserDto;

import java.util.Set;

public interface OrderService {

    Order createOrder(UserDto user, Set<Purchase> purchases) throws UserBalanceViolation
            , ProductQuantityLimitExceeded;
    Order findById(Long id);
}
