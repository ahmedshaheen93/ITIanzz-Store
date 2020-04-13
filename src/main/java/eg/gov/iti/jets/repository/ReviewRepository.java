package eg.gov.iti.jets.repository;

import eg.gov.iti.jets.model.Product;
import eg.gov.iti.jets.model.Review;

import java.util.List;

public interface ReviewRepository extends Crud<Review , Long> {
    List<Review> findByProduct(Product product);
}
