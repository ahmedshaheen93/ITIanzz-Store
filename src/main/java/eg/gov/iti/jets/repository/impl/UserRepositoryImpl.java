package eg.gov.iti.jets.repository.impl;

import eg.gov.iti.jets.model.User;
import eg.gov.iti.jets.repository.UserRepsitory;

public class UserRepositoryImpl extends CrudImpl<User, Long> implements UserRepsitory {

    public UserRepositoryImpl() {
        super();
    }
    
}
