package eg.gov.iti.jets.service;

import eg.gov.iti.jets.model.Product;
import eg.gov.iti.jets.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findByProduct(Product product);
    Review createReview(Review review);
}
