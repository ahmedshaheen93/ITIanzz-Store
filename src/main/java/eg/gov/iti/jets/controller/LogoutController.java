package eg.gov.iti.jets.controller;

import eg.gov.iti.jets.utilty.ReadWriteCookei;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "logout", urlPatterns = "/logout")
public class LogoutController extends HttpServlet {

    private static final long serialVersionUID = 170448480520412362L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("user");
        ReadWriteCookei.writeCookie(resp, "email", "", -100);
        req.getRequestDispatcher("logout.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
