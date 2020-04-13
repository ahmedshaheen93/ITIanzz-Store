package eg.gov.iti.jets.repository.impl;

import eg.gov.iti.jets.model.Product;
import eg.gov.iti.jets.model.Review;
import eg.gov.iti.jets.repository.ReviewRepository;

import java.util.List;
import java.util.Objects;

public class ReviewRepositoryImpl extends CrudImpl<Review , Long> implements ReviewRepository {
    private static ReviewRepositoryImpl instance = null;

    public static ReviewRepositoryImpl getInstance() {
        return instance = Objects.requireNonNullElseGet(instance ,  ReviewRepositoryImpl::new);
    }

    private ReviewRepositoryImpl() {
    }


    @Override
    public List<Review> findByProduct(Product product) {
         return (List<Review>) getEntityManager().createNamedQuery("Review.findByProduct")
                .setParameter("product", product)
                .getResultList();
    }
}
