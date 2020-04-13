package eg.gov.iti.jets.service.impl;

import eg.gov.iti.jets.exception.UserBalanceViolation;
import eg.gov.iti.jets.exception.UserNotFoundException;
import eg.gov.iti.jets.model.Address;
import eg.gov.iti.jets.model.Role;
import eg.gov.iti.jets.model.User;
import eg.gov.iti.jets.repository.UserRepository;
import eg.gov.iti.jets.repository.impl.UserRepositoryImpl;
import eg.gov.iti.jets.service.UserService;

import javax.persistence.NoResultException;

import java.time.LocalDate;
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
        return userRepository.save(user);
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
    public List<User> findAllUsers() {
        return userRepository.findAll();
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

    @Override
	public void checkAdminExistence() {
        List<User> allAdmins = userRepository.findALlAdminUsers();
        if (allAdmins.size() < 1) {
            User user = new User();
            user.setFirstName("Default");
            user.setLastName("Admin");
            user.setEmail("admin@store.com");
            user.setPassword("admin");
            user.setRole(Role.ADMIN_ROLE);
            user.setBirthDate(LocalDate.now());
            user.setBalance(0.0);
            user.setPhone("+ 02 353 556 56");
            user.setUserImage(null);

            Address address = new Address();
            address.setCountry("Egypt");
            address.setState("Cairo");
            address.setCity("6 October");
            address.setStreet("1st Street");
            address.setZipCode("12345");        
            user.setAddress(address);
            
            userRepository.save(user);
        }
	}

    @Override
    public User findByEmail(String email) throws NoResultException{
        User user = null;
        try {
            user = userRepository.findByEmail(email);
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return user;
    }
}
