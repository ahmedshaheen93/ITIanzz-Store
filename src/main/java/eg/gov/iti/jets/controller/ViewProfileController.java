package eg.gov.iti.jets.controller;

import eg.gov.iti.jets.exception.UserNotFoundException;
import eg.gov.iti.jets.model.Address;
import eg.gov.iti.jets.model.User;
import eg.gov.iti.jets.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "viewProfile", urlPatterns = "/view-profile")
public class ViewProfileController extends HttpServlet {

    private static final long serialVersionUID = 864991956010951061L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = (UserService) getServletContext().getAttribute("userService");
        int userId = Integer.parseInt(req.getParameter("id"));
        try {
            User userById = userService.findUserById(userId);
            req.setAttribute("user", userById);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", e.getMessage());
        }
        req.getRequestDispatcher("view-profile.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}