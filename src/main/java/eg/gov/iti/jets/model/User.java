package eg.gov.iti.jets.model;

import javax.persistence.*;

/**
 * User class represents users the system
 * which has a role of (CUSTOMER_ROLE OR ADMIN_ROLE)
 * to use the system as each role
 */
@Entity
@Table(name = "USERS")
public class User {
    /**
     * user id is a unique identifier for the user
     * that Generated automatic by jpa framework
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID", unique = true, nullable = false)
    private Long userId;
    /**
     * user first name with string type
     * has a column representation as FIRST_NAME
     * at table on database
     */
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    /**
     * user last name with string type
     * has a column representation as LAST_NAME
     * at table on database
     */
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;
    /**
     * user phone with string type
     * has a column representation as PHONE
     * at table on database
     */
    @Column(name = "PHONE", nullable = false)
    private String phone;
    /**
     * user email with string type
     * has a column representation as EMAIL
     * at table on database
     */
    @Column(name = "EMAIL", unique = true, updatable = false,
            nullable = false)
    private String email;
    /**
     * user password with string type
     * and should be encrypted and not views for the
     * upper com.iti.model
     * has a column representation as PASSWORD
     * at table on database
     */
    @Column(name = "PASSWORD",
            nullable = false)
    private String password;
    /**
     * user password with string type
     * and should be encrypted and not views for the
     * upper com.iti.model
     * has a column representation as PASSWORD
     * at table on database
     */
    @Column(name = "USER_ROLE", nullable = false)
    private Role role;

    public User() {
    }

    public User(String firstName, String lastName, String phone, String email, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    /**
     * get userId as user identifier
     *
     * @return userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * set userId
     *
     * @param userId long value for user id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
