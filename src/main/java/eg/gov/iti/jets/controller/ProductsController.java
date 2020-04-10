package eg.gov.iti.jets.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import eg.gov.iti.jets.model.Category;
import eg.gov.iti.jets.model.Product;
import eg.gov.iti.jets.model.dto.ProductDto;
import eg.gov.iti.jets.service.CategoryService;
import eg.gov.iti.jets.service.ProductService;

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
//        Product product = new Product();
//        product.setProductName("Korsy");
//        product.setSellPrice(5600d);
//        Image image = new Image();
//        image.setImagePath("images/home/img-products/product-7.png");
//        product.setPrimaryImage(image);
//
//        List<Product> productList = new ArrayList<>();
//        productList.add(product);
//        productList.add(product);
//        productList.add(product);
//        productList.add(product);
//        productList.add(product);
//        productList.add(product);
//
//
//        Category category = new Category("category1");
//        category.setCategoryId(1l);
//        Category category1 = new Category("category2");
//        category1.setCategoryId(2l);
//        Category category2 = new Category("category3");
//        category2.setCategoryId(3l);
//        Category category3 = new Category("category4");
//        category3.setCategoryId(4l);


        ProductService productService = (ProductService) getServletContext().getAttribute("productService");
        List<Product> allProducts = productService.findAllProducts();
        CategoryService categoryService =
                (CategoryService) getServletContext().getAttribute("categoryService");
        List<Category> categoryList = categoryService.getAllCategories();
        req.setAttribute("products", allProducts);
        req.setAttribute("categories", categoryList);
        req.getRequestDispatcher("products.jsp").include(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productsPar = req.getParameter("products");
        System.out.println("productsPar =>>>" + productsPar);
        if (productsPar != null) {
            Type listType = new TypeToken<ArrayList<Product>>() {
            }.getType();
            List<ProductDto> productDtos = new Gson().fromJson(productsPar, listType);
            System.out.println(productDtos);

            ProductService productService = (ProductService) getServletContext().getAttribute("productService");

            List<ProductDto> allProudects = productService.getAllProudects(productDtos);
            System.out.println("list ==============================");
            System.out.println(allProudects);


//            List<User> yourClassList = new Gson().fromJson(new FileReader("Listson.json"), listType);
//            System.out.println(Arrays.asList(yourClassList));
            String json = new Gson().toJson(allProudects, listType);
            System.out.println("=================================================");
            System.out.println(json);
            PrintWriter writer = resp.getWriter();

            writer.write(json);

        }
    }
}
