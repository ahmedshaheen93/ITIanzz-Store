package eg.gov.iti.jets.controller.product;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import eg.gov.iti.jets.model.Category;
import eg.gov.iti.jets.model.Product;
import eg.gov.iti.jets.model.dto.ProductDto;
import eg.gov.iti.jets.service.CategoryService;
import eg.gov.iti.jets.service.ProductService;
import eg.gov.iti.jets.utilty.ProductMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "products", urlPatterns = "/products")
public class ProductsController extends HttpServlet {

    private static final long serialVersionUID = 8649919520914806166L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = (ProductService) getServletContext().getAttribute("productService");
        List<Product> allProducts = productService.findAllProducts();
        CategoryService categoryService =
                (CategoryService) getServletContext().getAttribute("categoryService");
        List<Category> categoryList = categoryService.getAllCategories();
        List<ProductDto> allProductDtos = new ArrayList<>();
        for (Product product : allProducts) {
            allProductDtos.add(ProductMapper.mapToProductDto(product));
        }
        req.setAttribute("products", allProductDtos);
        req.setAttribute("categories", categoryList);
        req.getRequestDispatcher("products.jsp").include(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productsPar = req.getParameter("products");
        if (productsPar != null) {
            Type listType = new TypeToken<ArrayList<ProductDto>>() {
            }.getType();
            List<ProductDto> productDtos = new Gson().fromJson(productsPar, listType);
            ProductService productService = (ProductService) getServletContext().getAttribute("productService");
            List<ProductDto> allProudects = productService.getAllProducts(productDtos);
            String json = new Gson().toJson(allProudects);
            PrintWriter writer = resp.getWriter();
            writer.write(json);
        }
    }
}
