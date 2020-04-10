package eg.gov.iti.jets.service.impl;

import eg.gov.iti.jets.exception.UserBalanceViolation;
import eg.gov.iti.jets.exception.UserNotFoundException;
import eg.gov.iti.jets.model.User;
import eg.gov.iti.jets.repository.UserRepository;
import eg.gov.iti.jets.repository.impl.UserRepositoryImpl;
import eg.gov.iti.jets.service.UserService;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Objects;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl instance;
    private UserRepository userRepository;

    protected UserServiceImpl() {
        userRepository = UserRepositoryImpl.getInstance();
    }

    public static synchronized UserServiceImpl getInstance() {
        return Objects.requireNonNullElseGet(instance,
                () -> {
                    instance = new UserServiceImpl();
                    return instance;
                });
    }

    @Override
    public User register(User user) {
        //todo validate data first
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User login(String email, String password) throws UserNotFoundException {
        User user = null;
        try {
            user = userRepository.findByMailAndPassword(email, password);
        } catch (NoResultException e) {
            e.printStackTrace();
            throw new UserNotFoundException(String.format("%s not found on the database or " +
                    "incorrect password", email));
        }
        return user;
    }

    @Override
    public Double addUserBalance(User user, Double amount) throws UserBalanceViolation {
        Double newBalance = user.getBalance() + amount;
        if (newBalance < 0) {
            throw new UserBalanceViolation();
        }
        return userRepository.addUserBalance(user, amount);
    }

    @Override
    public List<User> getAllCustomerUsers() {
        return userRepository.findALlCustomerUsers();
    }

    @Override
    public User findUserById(long userId) throws UserNotFoundException{

        User user = null;
        try {
            user = userRepository.findById(userId);
        } catch (NoResultException e) {
            e.printStackTrace();
            throw new UserNotFoundException(String.format("%s not found on the database or " +
                    "incorrect id ", userId));
        }
        return user;
    }
}
