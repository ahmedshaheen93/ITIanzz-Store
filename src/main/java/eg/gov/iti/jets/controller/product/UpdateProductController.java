package eg.gov.iti.jets.controller.product;

import eg.gov.iti.jets.model.Category;
import eg.gov.iti.jets.model.Image;
import eg.gov.iti.jets.model.Product;
import eg.gov.iti.jets.service.CategoryService;
import eg.gov.iti.jets.service.ImageService;
import eg.gov.iti.jets.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@MultipartConfig(maxFileSize = 1024 * 1024 * 4)
@WebServlet(name = "update-product", urlPatterns = {"/update-product"})
public class UpdateProductController extends HttpServlet {

    private static final long serialVersionUID = -7444454604349503026L;

    private ProductService productService;
    private CategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        productService = (ProductService) getServletContext().getAttribute("productService");
        categoryService = (CategoryService) getServletContext().getAttribute("categoryService");
        String idParam = req.getParameter("id");
        if (idParam != null) {
            Product product = productService.findById(Long.valueOf(idParam));
            req.setAttribute("product", product);
            List<Category> allCategories = categoryService.getAllCategories();
            req.setAttribute("allCategories", allCategories);
            req.getRequestDispatcher("update-product.jsp").include(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        productService = (ProductService) getServletContext().getAttribute("productService");
        categoryService = (CategoryService) getServletContext().getAttribute("categoryService");
        long productId = Long.parseLong(req.getParameter("productId"));
        Product product = productService.findById(productId);
        String productName = req.getParameter("productName");
        String description = req.getParameter("description");
        String manufacturingName = req.getParameter("manufacturingName");
        String manufacturingDate = req.getParameter("manufacturingDate");
        String expirationDate = req.getParameter("expirationDate");
        String quantity = req.getParameter("quantity");
        String buyPrice = req.getParameter("buyPrice");
        String sellPrice = req.getParameter("sellPrice");

        String[] categories = req.getParameterValues("categories");
        List<Category> categoryList = new ArrayList<>();
        Arrays.asList(categories).forEach((categoryId) ->
                categoryList.add(categoryService.getCategoryById(Long.valueOf(categoryId))));
        ImageService imageService = (ImageService) getServletContext().getAttribute("imageService");
        String userHomeDir = System.getProperty("user.home") + "/iti-store/images";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Set<Image> allImages = imageService.saveImage(userHomeDir, req.getParts());

        product.setProductName(productName);
        product.setDescription(description);
        product.setManufacturingName(manufacturingName);
        product.setManufacturingDate(LocalDate.parse(manufacturingDate, formatter));
        product.setExpirationDate(LocalDate.parse(expirationDate, formatter));
        product.setQuantity(Integer.parseInt(quantity));
        product.setPrimaryImage(allImages.stream().findFirst().get());
        product.setBuyPrice(Double.parseDouble(buyPrice));
        product.setSellPrice(Double.parseDouble(sellPrice));

        product.getImages().clear();
        product.getImages().addAll(allImages);
        product.getCategories().clear();
        product.getCategories().addAll(categoryList);
        Product product1 = productService.updateProduct(product);
        resp.sendRedirect("view-product?id=" + product1.getProductId());
    }
}
