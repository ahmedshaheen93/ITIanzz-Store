package eg.gov.iti.jets.repository;

import eg.gov.iti.jets.model.User;

import javax.persistence.NoResultException;
import java.util.List;

public interface UserRepository extends Crud<User, Long> {
    /**
     * login operation
     *
     * @param email    user email to check with
     * @param password user password to check with
     * @return user if exists or null if not exists
     * @throws NoResultException if user not founded
     */
    User findByMailAndPassword(String email, String password) throws NoResultException;

    /**
     * @param email
     * @return
     */

    User findByEmail(String email);

    /**
     * check if the user has enough balance or not
     *
     * @param user    user to check his balance
     * @param balance amount of money to check if user balance grater than or not
     * @return true if user balance has enough money to go with
     */
    Boolean checkBalanceGreaterThan(User user, Double balance);

    /**
     * update user balance
     *
     * @param user   user to be updated
     * @param amount balance to be add to current user balance
     *               (current user balance (+) scratch card amount )
     *               (current user balance (-) total order amount )
     * @return current user balance after updated
     */
    Double addUserBalance(User user, Double amount);

    /**
     * find all admin users on the system
     *
     * @return list<User> admins
     */
    List<User> findALlAdminUsers();

}
