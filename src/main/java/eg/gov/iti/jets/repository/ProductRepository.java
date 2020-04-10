package eg.gov.iti.jets.repository;

import eg.gov.iti.jets.model.Category;
import eg.gov.iti.jets.model.Product;
import eg.gov.iti.jets.model.dto.ProductSearchExampleDTO;

import java.util.List;

public interface ProductRepository extends Crud<Product, Long> {
    /**
     * find all product its name like
     *
     * @param productName product name to search with
     * @return list<Product> founded on the system
     */
    List<Product> findByNameLike(String productName);

    /**
     * find all products with a category
     *
     * @param category to search with
     * @return list<Product> founded on the system
     */
    List<Product> findByCategory(Category category);

    /**
     * find all products between two prices
     *
     * @param price1 first price
     * @param price2 second price
     * @return list<Product> between two prices
     */
    List<Product> findBetweenTwoPrices(Double price1, Double price2);

    /**
     *
     * @param productSearchExampleDTO search by all possible data
     * @return List<Product>
     */
    List<Product> findByCategoryAndMinMaxPriceAndProductName(ProductSearchExampleDTO productSearchExampleDTO);
}
