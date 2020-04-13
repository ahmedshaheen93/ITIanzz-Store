package eg.gov.iti.jets.controller;

import eg.gov.iti.jets.model.Product;
import eg.gov.iti.jets.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "update-product", urlPatterns = {"/update-product"})
public class UpdateProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
        super.doPost(req, resp);
    }
}
