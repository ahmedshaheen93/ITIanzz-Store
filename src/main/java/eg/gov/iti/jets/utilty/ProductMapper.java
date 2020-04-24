package eg.gov.iti.jets.utilty;

import eg.gov.iti.jets.model.Category;
import eg.gov.iti.jets.model.Image;
import eg.gov.iti.jets.model.Product;
import eg.gov.iti.jets.model.Review;
import eg.gov.iti.jets.model.dto.ProductDto;
import eg.gov.iti.jets.model.dto.ReviewDto;
import eg.gov.iti.jets.service.ProductService;
import eg.gov.iti.jets.service.impl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductMapper {
    private static ProductService productService = ProductServiceImpl.getInstance();

    public static ProductDto mapToProductDto(Product product) {

        Set<String> categories = new HashSet<>(0);
        Set<Category> originalCategories = product.getCategories();
        for (Category category : originalCategories) {
            categories.add(category.getCategoryName());
        }

        String expireDate = (product.getExpirationDate() != null) ? product.getExpirationDate().toString() : "";
        Image primaryImage = product.getPrimaryImage();
        String imagePath = "";
        if (primaryImage != null)
            imagePath = "/iti-store/images?imageId=" + primaryImage.getImageId();

        Set<Image> originalImages = product.getImages();
        Set<String> images = new HashSet<>(0);
        for (Image image : originalImages) {
            images.add("/iti-store/images?imageId=" + image.getImageId());
        }
        ProductDto productDto = new ProductDto(product.getProductId(),
                product.getProductName(), product.getDescription(),
                product.getManufacturingName(),
                product.getManufacturingDate().toString(),
                expireDate
                , product.getQuantity(),
                categories, "" + product.getSellPrice(), imagePath, images);
        Set<Review> reviews = product.getReviews();
        List<ReviewDto> reviewDtos = new ArrayList<>();
        for (Review review : reviews) {
            ReviewDto reviewDto = ReviewMapper.mapToReviewDto(review);
            reviewDtos.add(reviewDto);
        }
        reviewDtos.sort((reviewDto1, reviewDto2) -> Math.max(reviewDto1.getReviewStars(), reviewDto2.getReviewStars()));

        productDto.getReviews().addAll(reviewDtos);

        return productDto;

    }

    public static Product mapToProductDto(ProductDto productDto) {
        return productService.findById(productDto.getProductId());
    }

}
