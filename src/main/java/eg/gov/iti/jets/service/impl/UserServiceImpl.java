package eg.gov.iti.jets.service.impl;

import eg.gov.iti.jets.exception.UserNotFoundException;
import eg.gov.iti.jets.model.User;
import eg.gov.iti.jets.repository.UserRepository;
import eg.gov.iti.jets.repository.impl.UserRepositoryImpl;
import eg.gov.iti.jets.service.UserService;

import javax.persistence.NoResultException;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository = UserRepositoryImpl.getInstance();

    @Override
    public User login(String email, String password) throws UserNotFoundException {
        User user = null;
        try {
            user = userRepository.findByMailAndPassword(email, password);
        } catch (NoResultException e) {
            e.printStackTrace();
            throw new UserNotFoundException(String.format("%s not found on the database or " +
                    "inccorect password", email));
        }
        return user;
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
}
