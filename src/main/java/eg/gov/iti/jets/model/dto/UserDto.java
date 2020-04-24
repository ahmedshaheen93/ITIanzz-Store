package eg.gov.iti.jets.model.dto;

import eg.gov.iti.jets.model.Address;
import eg.gov.iti.jets.model.Role;

import java.util.List;

public class UserDto {
    private Long userId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Role role;
    private double balance;
    private String birthDate;
    private String userImage;
    private Address address;
    private List<OrderDto> orders;

    public UserDto() {
    }

    public UserDto(Long userId, String firstName, String lastName,
                   String phone, String email, Role role,
                   double balance, String birthDate,
                   String userImage, Address address, List<OrderDto> orders) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.role = role;
        this.balance = balance;
        this.birthDate = birthDate;
        this.userImage = userImage;
        this.address = address;
        this.orders = orders;
    }

    public Long getUserId() {
        return userId;
    }

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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDto> orders) {
        this.orders = orders;
    }
}
