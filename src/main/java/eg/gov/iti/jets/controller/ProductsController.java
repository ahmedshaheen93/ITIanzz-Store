package eg.gov.iti.jets.controller;

import eg.gov.iti.jets.model.Category;
import eg.gov.iti.jets.model.Image;
import eg.gov.iti.jets.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "products", urlPatterns = "/products")
public class ProductsController extends HttpServlet {

    private static final long serialVersionUID = 8649919520914806166L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = new Product();
        product.setProductName("Korsy");
        product.setSellPrice(5600d);
        Image image = new Image();
        image.setImagePath("images/home/img-products/product-7.png");
        product.setPrimaryImage(image);

        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product);
        productList.add(product);
        productList.add(product);
        productList.add(product);
        productList.add(product);


        Category category = new Category("category1");
        category.setCategoryId(1l);
        Category category1 = new Category("category2");
        category1.setCategoryId(2l);
        Category category2 = new Category("category3");
        category2.setCategoryId(3l);
        Category category3 = new Category("category4");
        category3.setCategoryId(4l);
        List<Category> categoryList = Arrays.asList(category, category2, category1, category3);
        req.setAttribute("products", productList);
        req.setAttribute("categories", categoryList);
        req.getRequestDispatcher("products.jsp").include(req, resp);

    }
}
