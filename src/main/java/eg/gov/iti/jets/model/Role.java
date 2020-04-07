package eg.gov.iti.jets.model;

import java.io.Serializable;

/**
 * USER ROLE
 * contains two different role
 * CUSTOMER_ROLE (can login , register , add to cart ,buy ,
 * view own profile , update own profile ,etc  )
 * ADMIN_ROLE (can login , add product , view Customers profile , update products ,
 * review customers ,etc )
 */
public enum Role implements Serializable {
    CUSTOMER_ROLE,
    ADMIN_ROLE
}
