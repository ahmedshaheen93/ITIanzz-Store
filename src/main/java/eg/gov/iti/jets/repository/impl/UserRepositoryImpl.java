package eg.gov.iti.jets.repository.impl;

import eg.gov.iti.jets.model.User;
import eg.gov.iti.jets.repository.UserRepository;

import java.util.Objects;

public class UserRepositoryImpl extends CrudImpl<User, Long> implements UserRepository {
    private static UserRepositoryImpl instance;
    private final String findByMailAndPassword = "SELECT u FROM User u where u.email =:email and u.password = :password";

    private UserRepositoryImpl() {
        super();
    }

    public static synchronized UserRepositoryImpl getInstance() {
        return Objects.requireNonNullElseGet(instance, UserRepositoryImpl::new);
    }

    @Override
    public User findByMailAndPassword(String email, String password) {
        return (User) getEntityManager().createQuery(findByMailAndPassword)
                .setParameter("email", email)
                .setParameter("password", password).getSingleResult();
    }
}
