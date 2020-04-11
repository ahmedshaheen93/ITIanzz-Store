package eg.gov.iti.jets.controller;

import eg.gov.iti.jets.model.Category;
import eg.gov.iti.jets.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "addProduct" , urlPatterns = "/addProduct")
public class AddProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService categoryService = (CategoryService) getServletContext().getAttribute("categoryService");
        List<Category> allCategories = categoryService.getAllCategories();
        req.setAttribute("allCategories" , allCategories);
        req.getRequestDispatcher("add-product.jsp").forward(req,resp);
    }

}
