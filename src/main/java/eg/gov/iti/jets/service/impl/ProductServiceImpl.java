package eg.gov.iti.jets.service.impl;

import eg.gov.iti.jets.exception.ProductQuantityLimitExceeded;
import eg.gov.iti.jets.model.Category;
import eg.gov.iti.jets.model.Product;
import eg.gov.iti.jets.repository.ProductRepository;
import eg.gov.iti.jets.repository.impl.ProductRepositoryImpl;
import eg.gov.iti.jets.service.ProductService;

import java.util.List;
import java.util.Objects;

public class ProductServiceImpl implements ProductService {

    private static ProductServiceImpl instance;
    private ProductRepository productRepository;

    protected ProductServiceImpl() {
        productRepository = ProductRepositoryImpl.getInstance();
    }

    public static synchronized ProductServiceImpl getInstance() {
        return Objects.requireNonNullElseGet(instance,
                () -> {
                    instance = new ProductServiceImpl();
                    return instance;
                });

    }

    @Override
    public Product updateProductQuantity(Product product, int quantity) throws ProductQuantityLimitExceeded {
        int newQuantity = product.getQuantity() + quantity;
        if (newQuantity < 0) {
            throw new ProductQuantityLimitExceeded();
        }
        product.setQuantity(newQuantity);
        return productRepository.save(product);
    }

    @Override
    public List<Product> searchByCategory(Category category) {
        return productRepository.findByCategory(category);
    }
}
