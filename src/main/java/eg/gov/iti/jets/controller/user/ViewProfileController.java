package eg.gov.iti.jets.controller.user;

import eg.gov.iti.jets.model.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "view-profile", urlPatterns = "/view-profile")
public class ViewProfileController extends HttpServlet {

    private static final long serialVersionUID = 864991956010951061L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDto user = (UserDto) req.getSession().getAttribute("user");
        if (user != null) {
            System.out.println("final user befpr going to view is : " + user);
            req.getRequestDispatcher("view-profile.jsp").include(req, resp);
        } else {
            req.getRequestDispatcher("login.jsp").include(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}