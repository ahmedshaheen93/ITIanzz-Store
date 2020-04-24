package eg.gov.iti.jets.controller.user;

import eg.gov.iti.jets.model.Address;
import eg.gov.iti.jets.model.Role;
import eg.gov.iti.jets.model.dto.UserDto;
import eg.gov.iti.jets.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate bDate = LocalDate.parse(birthDate, formatter);

        String country = req.getParameter("country");
        String state = req.getParameter("state");
        String city = req.getParameter("city");
        String street = req.getParameter("street");
        String zipCode = req.getParameter("zipcode");
        Address address = new Address(country, state, city, street, zipCode);
//        String firstName, String lastName,
//                String phone, String email, Role role,
//        double balance, String birthDate,
//                String userImage, Address address, List< OrderDto > orders
        UserDto user = new UserDto(0l, firstName, lastName, phone, email, Role.CUSTOMER_ROLE, 0.0, bDate.toString(), null, address, null);

        UserService userService = (UserService) req.getServletContext().getAttribute("userService");
        userService.register(user, password);

        resp.sendRedirect("/iti-store/login");
    }
}
