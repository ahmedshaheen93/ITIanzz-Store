package eg.gov.iti.jets.service.impl;

import eg.gov.iti.jets.exception.ProductQuantityLimitExceeded;
import eg.gov.iti.jets.model.Category;
import eg.gov.iti.jets.model.Product;
import eg.gov.iti.jets.model.dto.ProductDto;
import eg.gov.iti.jets.model.dto.ProductSearchExampleDTO;
import eg.gov.iti.jets.repository.ProductRepository;
import eg.gov.iti.jets.repository.impl.ProductRepositoryImpl;
import eg.gov.iti.jets.service.ProductService;
import eg.gov.iti.jets.utilty.ProductMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

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

    @Override
    public List<Product> searchByProductDTO(ProductSearchExampleDTO exampleDTO) {
        return productRepository.findByCategoryAndMinMaxPriceAndProductName(exampleDTO);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
    @Override
    public ProductDto findById(Long productId) {
        ProductDto productDto = null;
        Product product = productRepository.findById(productId);
        if (product != null) {
            productDto = ProductMapper.mapToProductDto(product);
        }
        return productDto;
    }
    @Override
    public List<ProductDto> getAllProudects(List<ProductDto> productDtos) {
        Logger logger
                = Logger.getLogger(ProductServiceImpl.class.getName());
        List<ProductDto> productDtoSet = new ArrayList<>();
        System.out.println("in the getAllProudects method");
        logger.info("in the getAllProudects method");
        for (ProductDto productDto : productDtos) {
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            logger.info(productDto.getProductId()+"");
            Product byId = productRepository.findById(productDto.getProductId());
            ProductDto mapedProductDto = ProductMapper.mapToProductDto(byId);
            logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<BID>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+byId);
            logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<mapper>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+mapedProductDto);

            productDtoSet.add(mapedProductDto);
        }
        return productDtoSet;
    }
}
