package eg.gov.iti.jets.service.impl;

import eg.gov.iti.jets.model.Product;
import eg.gov.iti.jets.model.Review;
import eg.gov.iti.jets.repository.ReviewRepository;
import eg.gov.iti.jets.repository.impl.ReviewRepositoryImpl;
import eg.gov.iti.jets.service.ReviewService;

import java.util.List;
import java.util.Objects;

public class ReviewServiceImpl implements ReviewService {
    private static ReviewServiceImpl instance;
    ReviewRepository reviewRepository = ReviewRepositoryImpl.getInstance();

    private ReviewServiceImpl() {
    }

    public static ReviewServiceImpl getInstance() {
        return instance = Objects.requireNonNullElseGet(instance, ReviewServiceImpl::new);
    }

    @Override
    public List<Review> findByProduct(Product product) {
        return reviewRepository.findByProduct(product);
    }

    @Override
    public Review createReview(Review review) {
        return
                reviewRepository.save(review);
    }
}
