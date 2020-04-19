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


    @Column(name = "STORE_LINKS_TITLE")
    private String linksTitle;

    @Column(name = "STORE_LINK1")
    private String link1;
    
    @Column(name = "STORE_LINK2")
    private String link2;

    @Column(name = "STORE_LINK3")
    private String link3;

    @Column(name = "STORE_LINK4")
    private String link4;

    @Column(name = "STORE_LINK_ADDRESS1")
    private String linkAddress1;
    
    @Column(name = "STORE_LINK_ADDRESS2")
    private String linkAddress2;

    @Column(name = "STORE_LINK_ADDRESS3")
    private String linkAddress3;

    @Column(name = "STORE_LINK_ADDRESS4")
    private String linkAddress4;

    @Column(name = "STORE_SLIDER_TITLE1")
    private String sliderTitle1;

    @Column(name = "STORE_SLIDER_SUBTITLE1")
    private String sliderSubTitle1;

    @Column(name = "STORE_SLIDER_TITLE2")
    private String sliderTitle2;

    @Column(name = "STORE_SLIDER_SUBTITLE2")
    private String sliderSubTitle2;

    @Column(name = "STORE_SLIDER_TITLE3")
    private String sliderTitle3;

    @Column(name = "STORE_SLIDER_SUBTITLE3")
    private String sliderSubTitle3;

    @Column(name = "STORE_SLIDER_TITLE4")
    private String sliderTitle4;

    @Column(name = "STORE_SLIDER_SUBTITLE4")
    private String sliderSubTitle4;


    public Store() {
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

    public String getLinksTitle() {
        return linksTitle;
    }

    public void setLinksTitle(String linksTitle) {
        this.linksTitle = linksTitle;
    }

    public String getLink1() {
        return link1;
    }

    public void setLink1(String link1) {
        this.link1 = link1;
    }

    public String getLink2() {
        return link2;
    }

    public void setLink2(String link2) {
        this.link2 = link2;
    }

    public String getLink3() {
        return link3;
    }

    public void setLink3(String link3) {
        this.link3 = link3;
    }

    public String getLink4() {
        return link4;
    }

    public void setLink4(String link4) {
        this.link4 = link4;
    }

    public String getSliderTitle1() {
        return sliderTitle1;
    }

    public void setSliderTitle1(String sliderTitle1) {
        this.sliderTitle1 = sliderTitle1;
    }

    public String getSliderSubTitle1() {
        return sliderSubTitle1;
    }

    public void setSliderSubTitle1(String sliderSubTitle1) {
        this.sliderSubTitle1 = sliderSubTitle1;
    }

    public String getSliderTitle2() {
        return sliderTitle2;
    }

    public void setSliderTitle2(String sliderTitle2) {
        this.sliderTitle2 = sliderTitle2;
    }

    public String getSliderSubTitle2() {
        return sliderSubTitle2;
    }

    public void setSliderSubTitle2(String sliderSubTitle2) {
        this.sliderSubTitle2 = sliderSubTitle2;
    }

    public String getSliderTitle3() {
        return sliderTitle3;
    }

    public void setSliderTitle3(String sliderTitle3) {
        this.sliderTitle3 = sliderTitle3;
    }

    public String getSliderSubTitle3() {
        return sliderSubTitle3;
    }

    public void setSliderSubTitle3(String sliderSubTitle3) {
        this.sliderSubTitle3 = sliderSubTitle3;
    }

    public String getSliderTitle4() {
        return sliderTitle4;
    }

    public void setSliderTitle4(String sliderTitle4) {
        this.sliderTitle4 = sliderTitle4;
    }

    public String getSliderSubTitle4() {
        return sliderSubTitle4;
    }

    public void setSliderSubTitle4(String sliderSubTitle4) {
        this.sliderSubTitle4 = sliderSubTitle4;
    }

    public String getLinkAddress1() {
        return linkAddress1;
    }

    public void setLinkAddress1(String linkAddress1) {
        this.linkAddress1 = linkAddress1;
    }

    public String getLinkAddress2() {
        return linkAddress2;
    }

    public void setLinkAddress2(String linkAddress2) {
        this.linkAddress2 = linkAddress2;
    }

    public String getLinkAddress3() {
        return linkAddress3;
    }

    public void setLinkAddress3(String linkAddress3) {
        this.linkAddress3 = linkAddress3;
    }

    public String getLinkAddress4() {
        return linkAddress4;
    }

    public void setLinkAddress4(String linkAddress4) {
        this.linkAddress4 = linkAddress4;
    }

}
