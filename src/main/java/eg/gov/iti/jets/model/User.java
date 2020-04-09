package eg.gov.iti.jets.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * User class represents users the system which has a role of (CUSTOMER_ROLE OR
 * ADMIN_ROLE) to use the system as each role
 */

@Entity
@Table(name = "USERS")
@NamedQueries({
        @NamedQuery(name = "User.findByEmailAndPassword",
                query = "SELECT u from User u where u.email=:email and u.password=:password")
        ,
        @NamedQuery(name = "User.findByEmail",
                query = "SELECT u from User u where u.email=:email"),
        @NamedQuery(name = "User.getUserBalance",
                query = "SELECT u.balance from User u where u.userId =:id")
        ,
        @NamedQuery(name = "User.updateUserBalance",
                query = "UPDATE User u SET u.balance=:balance where u.userId =:id"),
        @NamedQuery(name = "User.getAllAdminUsers",
                query = "SELECT u from User u where u.role = eg.gov.iti.jets.model.Role.ADMIN_ROLE")
}
)

public class User implements Serializable {
    /**
     * user id is a unique identifier for the user that Generated automatic by jpa
     * framework
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID", unique = true, nullable = false)
    private Long userId;
    /**
     * user first name with string type has a column representation as FIRST_NAME at
     * table on database
     */
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    /**
     * user last name with string type has a column representation as LAST_NAME at
     * table on database
     */
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;
    /**
     * user phone with string type has a column representation as PHONE at table on
     * database
     */
    @Column(name = "PHONE", nullable = false)
    private String phone;
    /**
     * user email with string type has a column representation as EMAIL at table on
     * database
     */
    @Column(name = "EMAIL", unique = true, updatable = false, nullable = false)
    private String email;
    /**
     * user password with string type and should be encrypted and not views for the
     * upper com.iti.model has a column representation as PASSWORD at table on
     * database
     */
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    /**
     * user role with role type (CUSTOMER_ROLE OR ADMIN_ROLE)
     */
    @Column(name = "USER_ROLE", nullable = false)
    private Role role;

    @Column(name = "BALANCE", nullable = false)
    private double balance;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @OneToOne
    @JoinColumn(name = "IMAGE_ID")
    private Image userImage;

    @Embedded
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Order> orders = new HashSet<>(0);
    ;

    public User() {
    }

    public User(String firstName, String lastName, String phone, String email, String password, Role role,
                double balance, LocalDate birthDate, Image userImage, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
        this.balance = balance;
        this.birthDate = birthDate;
        this.userImage = userImage;
        this.address = address;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Image getUserImage() {
        return userImage;
    }

    public void setUserImage(Image userImage) {
        this.userImage = userImage;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", balance=" + balance +
                ", birthDate=" + birthDate +
                ", userImage=" + userImage +
                ", address=" + address +
                ", orders=" + orders +
                '}';
    }

    public void add(Order order) {
        if (orders == null) {
            this.orders = new HashSet<>(0);
        }
        orders.add(order);
        order.setUser(this);
    }
}