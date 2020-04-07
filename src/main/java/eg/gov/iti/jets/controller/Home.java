package eg.gov.iti.jets.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eg.gov.iti.jets.repository.UserRepsitory;
import eg.gov.iti.jets.repository.impl.UserRepositoryImpl;

import java.io.IOException;
@WebServlet(name = "Home",urlPatterns = {"/home"})
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepsitory ur = new UserRepositoryImpl();
        req.getRequestDispatcher("index.jsp").include(req,resp);
    }
}
