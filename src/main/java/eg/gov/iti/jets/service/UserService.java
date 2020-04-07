package eg.gov.iti.jets.service;

import eg.gov.iti.jets.exception.UserNotFoundException;
import eg.gov.iti.jets.model.User;

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

}
