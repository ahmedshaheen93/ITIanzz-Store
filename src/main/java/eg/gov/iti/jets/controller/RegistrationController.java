package eg.gov.iti.jets.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eg.gov.iti.jets.model.Address;
import eg.gov.iti.jets.model.Role;
import eg.gov.iti.jets.model.User;
import eg.gov.iti.jets.service.UserService;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "registration", urlPatterns = "/registration")
public class RegistrationController extends HttpServlet {

    private static final long serialVersionUID = 6939353956740642067L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String birthDate = req.getParameter("birthdate");

        String country = req.getParameter("country");
        String state = req.getParameter("state");
        String city = req.getParameter("city");
        String street = req.getParameter("street");
        String zipCode = req.getParameter("zipcode");
        Address address = new Address(country, state, city, street, zipCode);

        User user = new User(firstName, lastName, phone, email, password, Role.CUSTOMER_ROLE, 0.0, LocalDate.now(), null, address);

        UserService userService = (UserService) req.getServletContext().getAttribute("userService");
        userService.update(user);

        resp.sendRedirect("login.jsp");
    }
}
