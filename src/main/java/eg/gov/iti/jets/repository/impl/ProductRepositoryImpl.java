package eg.gov.iti.jets.repository.impl;

import eg.gov.iti.jets.model.Category;
import eg.gov.iti.jets.model.Product;
import eg.gov.iti.jets.model.dto.ProductSearchExampleDTO;
import eg.gov.iti.jets.repository.ProductRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductRepositoryImpl extends CrudImpl<Product, Long>
        implements ProductRepository {
    private static ProductRepositoryImpl instance;

    private ProductRepositoryImpl() {
    }



    public static synchronized ProductRepositoryImpl getInstance() {
        return Objects.requireNonNullElseGet(instance,
                () -> {
                    instance = new ProductRepositoryImpl();
                    return instance;
                });
    }

    @Override
    public List<Product> findByNameLike(String productName) {
        return (List<Product>) getEntityManager().createNamedQuery("Product.findByNameLike").
                setParameter("productName", "%" + productName + "%").getResultList();
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return (List<Product>) getEntityManager().createNamedQuery("Product.findByCategory").
                setParameter("category", category).getResultList();
    }

    @Override
    public List<Product> findBetweenTwoPrices(Double price1, Double price2) {
        return (List<Product>) getEntityManager()
                .createNamedQuery("Product.findBetweenTwoPrices")
                .setParameter("price1", price1)
                .setParameter("price2", price2)
                .getResultList();
    }
    @Override
    public List<Product> findByCategoryAndMinMaxPriceAndProductName(ProductSearchExampleDTO productSearchExampleDTO) {
        Category category = new Category();
        category.setCategoryId(productSearchExampleDTO.getCategoryId());
        return ((List<Product>) getEntityManager()
                .createNamedQuery("Product.findByCategoryAndMinMaxPriceAndProductName")
                .setParameter("price1", (double) productSearchExampleDTO.getMin())
                .setParameter("price2", (double) productSearchExampleDTO.getMax())
                .setParameter("productName", "%" + productSearchExampleDTO.getProductName() + "%")
                .setParameter("category", category).getResultList());
    }

    @Override
    public void delete(Product product) {
        //super.delete(product);
        product.setDeleted(true);
        update(product);
    }

    @Override
    public List<Product> findAll() {
        List<Product> all = super.findAll();
        return all.stream().filter(product -> !product.isDeleted()).collect(Collectors.toList());
    }
}
