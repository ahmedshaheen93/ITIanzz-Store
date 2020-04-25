package eg.gov.iti.jets.service;

import eg.gov.iti.jets.exception.UserBalanceViolation;
import eg.gov.iti.jets.exception.UserNotFoundException;
import eg.gov.iti.jets.model.Role;
import eg.gov.iti.jets.model.User;
import eg.gov.iti.jets.model.dto.UserDto;

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
    UserDto login(String email, String password) throws UserNotFoundException;

    UserDto register(UserDto userDto, String password);

    UserDto update(UserDto userDto, String password);

    UserDto updateUserRole(String email, Role role);

    Double addUserBalance(UserDto user, Double amount) throws UserBalanceViolation;

    List<UserDto> findAllUsers();

    UserDto findUserById(Long userId) throws UserNotFoundException;

    void checkAdminExistence();

    UserDto findByEmail(String email) throws NoResultException;

    User findById(Long id) throws NoResultException;

}
