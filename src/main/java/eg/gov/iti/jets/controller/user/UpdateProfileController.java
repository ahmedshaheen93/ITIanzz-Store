package eg.gov.iti.jets.controller.user;

import eg.gov.iti.jets.model.Address;
import eg.gov.iti.jets.model.Image;
import eg.gov.iti.jets.model.User;
import eg.gov.iti.jets.service.ImageService;
import eg.gov.iti.jets.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Set;

@MultipartConfig(maxFileSize = 1024 * 1024 * 4)
@WebServlet(name = "updateProfile", urlPatterns = "/update-profile")
public class UpdateProfileController extends HttpServlet {

    private static final long serialVersionUID = -445796056010951061L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        UserService userService = (UserService) getServletContext().getAttribute("userService");
//        int id = Integer.parseInt(req.getParameter("id"));
//        try {
//            User userById = userService.findUserById(id);
//            req.setAttribute("user", userById);
//        } catch (UserNotFoundException e) {
//            e.printStackTrace();
//            req.setAttribute("errorMessage", e.getMessage());
//        }
//

        req.getRequestDispatcher("update-profile.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("update user profile");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String country = req.getParameter("country");
        String city = req.getParameter("city");
        String zipCode = req.getParameter("zipCode");
        String state = req.getParameter("state");
        String street = req.getParameter("street");
        Part userImage = req.getPart("image");
        System.out.println("req.getPart(\"userImage\");" + req.getPart("userImage"));
        UserService userService = (UserService) getServletContext().getAttribute("userService");
        User user = (User) req.getSession().getAttribute("user");
        user.setFirstName(firstName);
        user.setPhone(phone);
        user.setLastName(lastName);
        user.setEmail(email);

        Address address = new Address();
        address.setCountry(country);
        address.setCity(city);
        address.setZipCode(zipCode);
        address.setState(state);
        address.setStreet(street);
        user.setAddress(address);

        if (userImage != null) {
            System.out.println("here");
            ImageService imageService = (ImageService) getServletContext().getAttribute("imageService");
            String userHomeDir = System.getProperty("user.home") + "/iti-store/images";
            Set<Image> images = imageService.saveImage(userHomeDir, req.getParts());
            System.out.println("Set<Image> images" + images);
            Image image = images.stream().findFirst().get();
            System.out.println("image" + image);
            user.setUserImage(image);
        }

        userService.update(user);
//        } catch (UserNotFoundException e) {
//            e.printStackTrace();
//        }
        resp.sendRedirect("view-profile");
    }
}