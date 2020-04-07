package eg.gov.iti.jets.repository;

import eg.gov.iti.jets.model.User;

public interface UserRepository extends Crud<User, Long> {
    User findByMailAndPassword(String email, String password);
}
