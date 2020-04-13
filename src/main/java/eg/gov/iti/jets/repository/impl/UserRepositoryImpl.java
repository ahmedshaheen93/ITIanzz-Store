package eg.gov.iti.jets.repository.impl;

import eg.gov.iti.jets.model.User;
import eg.gov.iti.jets.repository.UserRepository;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Objects;

public class UserRepositoryImpl extends CrudImpl<User, Long> implements UserRepository {
    private static UserRepositoryImpl instance;

    private UserRepositoryImpl() {
        super();
    }

    public static synchronized UserRepositoryImpl getInstance() {
        return Objects.requireNonNullElseGet(instance,
                () -> {
                    instance = new UserRepositoryImpl();
                    return instance;
                });
    }

    @Override
    public User findByMailAndPassword(String email, String password) throws NoResultException {
        return (User) getEntityManager().createNamedQuery("User.findByEmailAndPassword")
                .setParameter("email", email)
                .setParameter("password", password).getSingleResult();
    }

    @Override
    public User findByEmail(String email) throws NoResultException {
        return (User) getEntityManager().createNamedQuery("User.findByEmail")
                .setParameter("email", email).getSingleResult();
    }

    @Override
    public Boolean checkBalanceGreaterThan(User user, Double balance) {
        Double currentUserBalance = (Double) getEntityManager().createNamedQuery("User.getUserBalance")
                .setParameter("id", user.getUserId()).getSingleResult();
        return currentUserBalance >= balance;
    }

    @Override
    public Double addUserBalance(User user, Double balance) {
        Double newBalance = user.getBalance() + balance;
        getEntityManager().getTransaction().begin();
        int executeUpdate = getEntityManager().createNamedQuery("User.updateUserBalance")
                .setParameter("balance", newBalance)
                .setParameter("id", user.getUserId()).executeUpdate();
        getEntityManager().getTransaction().commit();
        if (executeUpdate > 0) {
            user.setBalance(newBalance);
            return newBalance;
        }
        return -1d;
    }

    @Override
    public List<User> findALlAdminUsers() {
        return (List<User>) getEntityManager().createNamedQuery("User.getAllAdminUsers").getResultList();
    }

    @Override
    public List<User> findALlCustomerUsers() {
        return (List<User>) getEntityManager().createNamedQuery("User.getAllCustomerUsers").getResultList();
    }

//    @Override
//    public User findById(Long id) {
//        return (User) getEntityManager().createNamedQuery("User.findById")
//                .setParameter("userId", id).getSingleResult();
//    }
}
