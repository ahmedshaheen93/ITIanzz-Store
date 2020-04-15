package eg.gov.iti.jets.controller;

import eg.gov.iti.jets.model.Category;
import eg.gov.iti.jets.model.Image;
import eg.gov.iti.jets.model.Product;
import eg.gov.iti.jets.service.CategoryService;
import eg.gov.iti.jets.service.ImageService;
import eg.gov.iti.jets.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@WebServlet(name = "update-product", urlPatterns = {"/update-product"})
public class UpdateProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //TODO still work on it
        //@noura
        ProductService productService = (ProductService) getServletContext().getAttribute("productService");
        String idParam = req.getParameter("id");
        if(idParam != null){

            Product product = productService.findById(Long.valueOf(idParam));

        }
        //List<Category> allCategories = categoryService.getAllCategories();
        //req.setAttribute("allCategories", allCategories);

        req.setAttribute("product", new Product());
        req.getRequestDispatcher("update-product.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductService productService = (ProductService) getServletContext().getAttribute("productService");
        CategoryService categoryService = (CategoryService) getServletContext().getAttribute("categoryService");

        long productId = Long.parseLong(req.getParameter("productId"));
        Product product = productService.findById(productId);
        String productName = req.getParameter("productName");
        String description = req.getParameter("description");
        String manufacturingName = req.getParameter("manufacturingName");
        String manufacturingDate = req.getParameter("manufacturingDate");
        String expirationDate =  req.getParameter("expirationDate");
        String quantity = req.getParameter("quantity");
        String buyPrice = req.getParameter("buyPrice");
        String sellPrice = req.getParameter("sellPrice");
        String categoryId = req.getParameter("categories");
        Category categoryById = categoryService.getCategoryById(Long.parseLong(categoryId));

        ImageService imageService = (ImageService) getServletContext().getAttribute("imageService");
        String userHomeDir = System.getProperty("user.home") + "/iti-store/images";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
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
        product.getImages().addAll(allImages);
        product.getCategories().add(categoryById);
        Product product1 = productService.updateProduct(product);
        resp.sendRedirect("view-product?id=" + product1.getProductId());
    }
}
