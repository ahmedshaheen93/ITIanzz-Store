package eg.gov.iti.jets.service;

import eg.gov.iti.jets.exception.ProductQuantityLimitExceeded;
import eg.gov.iti.jets.model.Category;
import eg.gov.iti.jets.model.Product;

import java.util.List;

public interface ProductService {
    /**
     * update product quantity with quantity to
     * be increase or decrees
     * (product quantity (+) quantity) buy product and update the store
     * (product quantity (-) quantity) sell product and create order
     *
     * @param product  to be updated
     * @param quantity (+/-) depend on the operation
     * @return Product after updated
     * @throws ProductQuantityLimitExceeded if the ProductQuantity goes to be negative
     */
    Product updateProductQuantity(Product product, int quantity) throws ProductQuantityLimitExceeded;

    List<Product> searchByCategory(Category category);
}
