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
    @JoinColumn(name = "IMAGE_ID")
    private Image logo;

    @Column(name = "STORE_NAME", nullable = false)
    private String storeName;

    @Embedded
    private Address address;

    @Column(name = "STORE_DESCRIPTION", length = 5000)
    private String description;

    @Column(name = "STORE_PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @Column(name = "STORE_FAX_NUMBER", nullable = false)
    private String faxNumber;

    @Column(name = "STORE_EMAIL", nullable = false)
    private String email;

    @Column(name = "STORE_FACEBOOK")
    private String faceBook;
    
    @Column(name = "STORE_TWITTER")
    private String twitter;

    @Column(name = "STORE_YOUTUBE")
    private String youtube;

    @Column(name = "STORE_LINKEDIN")
    private String linkedin;

    @Column(name = "STORE_INSTAGRAM")
    private String instagram;

    public Store() {
    }

    public Store(Image logo, String storeName, Address address, String description, String phoneNumber,
            String faxNumber, String email, String faceBook, String twitter, String youtube, String linkedin,
            String instagram) {
        this.logo = logo;
        this.storeName = storeName;
        this.address = address;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.email = email;
        this.faceBook = faceBook;
        this.twitter = twitter;
        this.youtube = youtube;
        this.linkedin = linkedin;
        this.instagram = instagram;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
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

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    @Override
    public String toString() {
        return "Store [address=" + address + ", description=" + description + ", email=" + email + ", faceBook="
                + faceBook + ", faxNumber=" + faxNumber + ", instagram=" + instagram + ", linkedin=" + linkedin
                + ", logo=" + logo + ", phoneNumber=" + phoneNumber + ", storeId=" + storeId + ", storeName="
                + storeName + ", twitter=" + twitter + ", youtube=" + youtube + "]";
    }

}
