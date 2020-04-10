package eg.gov.iti.jets.controller;

import com.google.gson.Gson;
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
import java.util.List;

@WebServlet(name = "searchByProduct", urlPatterns = "/searchByCategory")
public class SearchByCategoryController extends HttpServlet {

    private static final long serialVersionUID = 2077012305145887632L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryId = req.getParameter("categoryId");
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
        }


    }
}
