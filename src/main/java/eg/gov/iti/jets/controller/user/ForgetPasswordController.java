package eg.gov.iti.jets.controller.user;

import eg.gov.iti.jets.model.dto.UserDto;
import eg.gov.iti.jets.service.MailService;
import eg.gov.iti.jets.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "forgetPassword", urlPatterns = "/forgetPassword")
public class ForgetPasswordController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("forgetPassword.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        UserService userService = (UserService) getServletContext().getAttribute("userService");
        UserDto user = userService.findByEmail(email);
        if (user != null) {
            MailService mailService = (MailService) getServletContext().getAttribute("mailService");
//            user.setPassword("randomPassword");
            user = userService.update(user, "randomPassword");
            mailService.sendForgetPasswordMail(user, "randomPassword");
            resp.sendRedirect("/iti-store/login");
        } else {
            req.setAttribute("errorMessage", "this email isn't found please check your data");
            req.getRequestDispatcher("forgetPassword.jsp").include(req, resp);
        }
    }
}
