package eg.gov.iti.jets.utilty;

import eg.gov.iti.jets.model.Review;
import eg.gov.iti.jets.model.User;
import eg.gov.iti.jets.model.dto.ReviewDto;

public class ReviewMapper {
    public static ReviewDto mapToReviewDto(Review review) {
        User user = review.getUser();
        return new ReviewDto(review.getReviewMessage(),
                review.getReviewMessageTime() + "",
                review.getReviewStars(), user.getFirstName() + " " +
                user.getLastName());
    }
}
