package eg.gov.iti.jets.service;

import eg.gov.iti.jets.exception.UserBalanceViolation;
import eg.gov.iti.jets.exception.UserNotFoundException;
import eg.gov.iti.jets.model.User;

import javax.persistence.NoResultException;
import java.util.List;

public interface UserService {
    /**
     * login to system
     *
     * @param email    user email to login with
     * @param password user password to login with
     * @return user if exists on the system
     */
    User login(String email, String password) throws UserNotFoundException;

    User register(User user);

    User update(User user);

    Double addUserBalance(User user, Double amount) throws UserBalanceViolation;

    List<User> findAllUsers();

    User findUserById(long userId) throws UserNotFoundException;

    void checkAdminExistence();

    User findByEmail(String email) throws NoResultException;
}
