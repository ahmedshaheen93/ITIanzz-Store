package eg.gov.iti.jets.controller.user;

import eg.gov.iti.jets.model.dto.UserDto;
import eg.gov.iti.jets.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "customers", urlPatterns = "/customers")
public class CustomersController extends HttpServlet {

    private static final long serialVersionUID = -3360620168457699080L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = (UserService) req.getServletContext().getAttribute("userService");
        List<UserDto> users = userService.findAllUsers();
        req.setAttribute("users", users);
        req.getRequestDispatcher("customers.jsp").include(req, resp);

    }

}
