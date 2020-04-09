package eg.gov.iti.jets.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "STORE")
public class Store implements Serializable {

    private static final long serialVersionUID = -405961668270253161L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STORE_ID", unique = true, nullable = false)
    private Long storeId;

    @OneToOne
    @JoinColumn(name = "IMAGE_ID", nullable = false)
    private Image logo;

    @Column(name = "STORE_NAME", nullable = false)
    private String storeName;

    @Embedded
    private Address address;

    @Column(name = "STORE_DESCRIPTION", length = 5000)
    private String description;

    @Column(name = "STORE_PHONE", nullable = false)
    private String phone;

    @Column(name = "STORE_EMAIL", nullable = false)
    private String email;

    @Column(name = "STORE_FACEBOOK")
    private String faceBook;

    @Column(name = "STORE_YOUTUBE")
    private String youtube;

    @Column(name = "STORE_INSTAGRAM")
    private String instagram;

    @Column(name = "STORE_TWITTER")
    private String twitter;

    public Store() {
    }

    public Store(Image logo, String storeName, Address address, String description, String phone, String email, String faceBook, String youtube, String instagram, String twitter) {
        this.logo = logo;
        this.storeName = storeName;
        this.address = address;
        this.description = description;
        this.phone = phone;
        this.email = email;
        this.faceBook = faceBook;
        this.youtube = youtube;
        this.instagram = instagram;
        this.twitter = twitter;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getFaceBook() {
        return faceBook;
    }

    public void setFaceBook(String faceBook) {
        this.faceBook = faceBook;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
}
