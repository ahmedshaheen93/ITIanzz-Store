package eg.gov.iti.jets.controller;

import eg.gov.iti.jets.exception.UserNotFoundException;
import eg.gov.iti.jets.model.dto.UserDto;
import eg.gov.iti.jets.service.UserService;
import eg.gov.iti.jets.utilty.ReadWriteCookei;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginController extends HttpServlet {

    private static final long serialVersionUID = -1852098991598893531L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String notAuthorize = req.getParameter("authorize");
        String mail = req.getParameter("mail");
        if (notAuthorize != null) {
            req.setAttribute("errorMessage", "You dont have authority to view this page , please login as admin");
        }
        if (mail != null) {
            req.setAttribute("errorMessage", "An Email has been send Please Check your inbox");
        }
        req.getRequestDispatcher("login.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = (UserService) getServletContext().getAttribute("userService");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        System.out.println("email=" + email + " password=" + password);
        try {
            if (email != null && password != null) {
                UserDto user = userService.login(email, password);
                if (user != null) {
                    req.getSession().setAttribute("user", user);
                    ReadWriteCookei.writeCookie(resp, "email", email, 60 * 60 * 60 * 24);
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                }
            }
            req.setAttribute("errorMessage", "enter a vaild data");
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", e.getMessage());
        }
        req.getRequestDispatcher("login.jsp").include(req, resp);
    }
}
