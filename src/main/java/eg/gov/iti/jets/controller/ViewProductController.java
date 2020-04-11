package eg.gov.iti.jets.controller;

import eg.gov.iti.jets.model.dto.ProductDto;
import eg.gov.iti.jets.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "view-product", urlPatterns = {"/view-product"})
public class ViewProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductService productService = (ProductService) getServletContext().getAttribute("productService");
        long productId = Long.parseLong(req.getParameter("id"));
        ProductDto product = productService.findById(productId);
        req.setAttribute("product", product);
        req.getRequestDispatcher("view-product.jsp").include(req, resp);
    }
}
