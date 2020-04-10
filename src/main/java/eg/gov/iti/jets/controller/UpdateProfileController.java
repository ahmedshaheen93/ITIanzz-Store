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

@WebServlet(name = "updateProfile", urlPatterns = "/update-profile")
public class UpdateProfileController extends HttpServlet {

    private static final long serialVersionUID = -445796056010951061L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = (UserService) getServletContext().getAttribute("userService");
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            User userById = userService.findUserById(id);
            req.setAttribute("user", userById);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", e.getMessage());
        }

        req.getRequestDispatcher("update-profile.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String country = req.getParameter("country");
        String city = req.getParameter("city");
        String zipCode = req.getParameter("zipCode");

        UserService userService = (UserService) getServletContext().getAttribute("userService");
        try {
            User user = userService.findUserById(id);

            user.setFirstName(firstName);
            user.setPhone(phone);
            user.setLastName(lastName);
            user.setEmail(email);

            Address address = new Address();
            address.setCountry(country);
            address.setCity(city);
            address.setZipCode(zipCode);
            user.setAddress(address);

            userService.update(user);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("profile?id=" + id);
    }
}