package eg.gov.iti.jets.controller.product;

import com.google.gson.Gson;
import eg.gov.iti.jets.model.Category;
import eg.gov.iti.jets.model.dto.ResponeMessage;
import eg.gov.iti.jets.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addCategory", urlPatterns = "/newCategory")
public class AddCategory extends HttpServlet {

    private static final long serialVersionUID = 7350381752033936712L;

    CategoryService categoryService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newCat = req.getParameter("newCat");
        categoryService = (CategoryService) getServletContext().getAttribute("categoryService");
        Category category = new Category();
        category.setCategoryName(newCat);
        Category persistedCategory = categoryService.addCategory(category);
        PrintWriter writer = resp.getWriter();
        if (persistedCategory != null) {
            resp.setStatus(200);
            String json = new Gson().toJson(persistedCategory);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().println(json);
        } else {
            resp.setStatus(400);
            ResponeMessage responeMessage = new ResponeMessage("Error while inserting the new category ordered", 200);
            String json = new Gson().toJson(responeMessage);
            writer.write(json);
        }
    }
}
