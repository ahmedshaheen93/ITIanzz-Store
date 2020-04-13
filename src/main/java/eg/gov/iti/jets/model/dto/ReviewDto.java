package eg.gov.iti.jets.model.dto;

public class ReviewDto {
    private Long id;
    private String reviewMessage;
    private String reviewMessageTime;
    private int reviewStars;
    private String userName;

    public ReviewDto(String reviewMessage, String reviewMessageTime, int reviewStars, String userName) {
        this.reviewMessage = reviewMessage;
        this.reviewMessageTime = reviewMessageTime;
        this.reviewStars = reviewStars;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReviewMessage() {
        return reviewMessage;
    }

    public void setReviewMessage(String reviewMessage) {
        this.reviewMessage = reviewMessage;
    }

    public String getReviewMessageTime() {
        return reviewMessageTime;
    }

    public void setReviewMessageTime(String reviewMessageTime) {
        this.reviewMessageTime = reviewMessageTime;
    }

    public int getReviewStars() {
        return reviewStars;
    }

    public void setReviewStars(int reviewStars) {
        this.reviewStars = reviewStars;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
