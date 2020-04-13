package eg.gov.iti.jets.model;

import oracle.jdbc.driver.DatabaseError;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "REVIEWS")
@NamedQueries(@NamedQuery(name = "Review.findByProduct" , query = "select r from Review r where r.product = :product"))
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REVIEW_ID", nullable = false)
    private Long reviewId;

   @ManyToOne(fetch = FetchType.LAZY,
           cascade = {CascadeType.DETACH,
           CascadeType.MERGE,
           CascadeType.PERSIST,
           CascadeType.REFRESH})
   @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "PRODUCT_ID" , nullable = false)
    private Product product;

    @Column(name = "REVIEW_MESSAGE" , nullable = false)
    private String reviewMessage;

    @Column(name = "REVIEW_MESSAGE_DATE" , nullable = false)
    private LocalDateTime reviewMessageTime;

    @Column(name = "REVIEW_STARS" , nullable = false)
    private int reviewStars;

    public Review(User user , Product product , String reviewMessage , LocalDateTime reviewMessageTime , int reviewStars) {
        this.user = user;
        this.product = product;
        this.reviewMessage = reviewMessage;
        this.reviewMessageTime = reviewMessageTime;
        this.reviewStars = reviewStars;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getReviewMessage() {
        return reviewMessage;
    }

    public void setReviewMessage(String reviewMessage) {
        this.reviewMessage = reviewMessage;
    }

    public LocalDateTime getReviewMessageTime() {
        return reviewMessageTime;
    }

    public void setReviewMessageTime(LocalDateTime reviewMessageTime) {
        this.reviewMessageTime = reviewMessageTime;
    }

    public int getReviewStars() {
        return reviewStars;
    }

    public void setReviewStars(int reviewStars) {
        this.reviewStars = reviewStars;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", user=" + user +
                ", product=" + product +
                ", reviewMessage='" + reviewMessage + '\'' +
                ", reviewMessageTime=" + reviewMessageTime +
                ", reviewStars=" + reviewStars +
                '}';
    }
}
