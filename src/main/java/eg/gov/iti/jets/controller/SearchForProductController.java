package eg.gov.iti.jets.controller;

import com.google.gson.Gson;
import eg.gov.iti.jets.model.Category;
import eg.gov.iti.jets.model.Image;
import eg.gov.iti.jets.model.Product;
import eg.gov.iti.jets.model.dto.ProductSearchExampleDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "searchForProduct", urlPatterns = "/searchForProduct")
public class SearchForProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        if (message != null && !message.isEmpty()) {
            ProductSearchExampleDTO productSearchExampleDTO = new Gson().fromJson(message, ProductSearchExampleDTO.class);
            System.out.println(productSearchExampleDTO);
            Product product = new Product();
            product.setProductName("korsy");
            product.setSellPrice(5600d);
            Image image = new Image();
            image.setImagePath("images/home/img-products/product-7.png");
            product.setPrimaryImage(image);
            List<Product> productList = new ArrayList<>();
            productList.add(product);

            String json = new Gson().toJson(productList);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().println(json);
        }

    }
    /*
    *  String categoryId = req.getParameter("categoryId");
        String min = req.getParameter("min");
        String max = req.getParameter("max");
        if (categoryId != null) {
            System.out.println("categoryId>>>>>>>>>>" + categoryId);
            Category category = new Category();
            category.setCategoryId(Long.parseLong(categoryId));
            Product product = new Product();
            product.setProductName("korsy");
            product.setSellPrice(5600d);
            Image image = new Image();
            image.setImagePath("images/home/img-products/product-7.png");
            product.setPrimaryImage(image);

            List<Product> productList = new ArrayList<>();
            productList.add(product);
            productList.add(product);
            productList.add(product);
//            ProductService productService = (ProductService) getServletContext().getAttribute("productService");
//            List<Product> products = productService.searchByCategory(category);
            String json = new Gson().toJson(productList);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().println(json);
//            req.setAttribute("products", products);
//            req.getRequestDispatcher("products.jsp").include(req, resp);
        }else if (min != null && max != null) {
            Product product = new Product();
            product.setProductName("korsy");
            product.setSellPrice(5600d);
            Image image = new Image();
            image.setImagePath("images/home/img-products/product-7.png");
            product.setPrimaryImage(image);
            List<Product> productList = new ArrayList<>();
            productList.add(product);

            String json = new Gson().toJson(productList);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().println(json);


        }
    * */
}
