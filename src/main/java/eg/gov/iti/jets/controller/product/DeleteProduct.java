package eg.gov.iti.jets.controller.product;

import eg.gov.iti.jets.model.Category;
import eg.gov.iti.jets.model.Product;
import eg.gov.iti.jets.service.CategoryService;
import eg.gov.iti.jets.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteProduct", urlPatterns = {"/deleteProduct"})
public class DeleteProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductService productService = (ProductService) getServletContext().getAttribute("productService");
        String idParam = req.getParameter("id");
        if (idParam != null) {
            Product product = productService.findById(Long.parseLong(idParam));
            productService.remveProduct(product);
        }
       resp.sendRedirect("products.jsp");
    }
}
