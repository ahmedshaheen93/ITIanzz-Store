package eg.gov.iti.jets.controller.user;


import eg.gov.iti.jets.exception.NoUpdatesException;
import eg.gov.iti.jets.model.Address;
import eg.gov.iti.jets.model.Image;
import eg.gov.iti.jets.model.dto.UserDto;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String birthDate = req.getParameter("birthDate");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String country = req.getParameter("country");
        String city = req.getParameter("city");
        String zipCode = req.getParameter("zipCode");
        String state = req.getParameter("state");
        String street = req.getParameter("street");
        Part userImage = req.getPart("image");
        UserService userService = (UserService) getServletContext().getAttribute("userService");
//        try {
//            User user = userService.findUserById(id);

        Address address = new Address();
        address.setCountry(country);
        address.setCity(city);
        address.setZipCode(zipCode);
        address.setState(state);
        address.setStreet(street);

        UserDto temp = new UserDto();
        UserDto user = (UserDto) req.getSession().getAttribute("user");

        temp.setFirstName(firstName);
        temp.setLastName(lastName);
        temp.setPhone(phone);
        temp.setEmail(email);
        temp.setAddress(address);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        temp.setBirthDate(LocalDate.parse(birthDate, formatter).toString());

        Image image = null;
        if (!userImage.getSubmittedFileName().isBlank()) {
            ImageService imageService = (ImageService) getServletContext().getAttribute("imageService");
            String userHomeDir = System.getProperty("user.home") + "/iti-store/images";
            Set<Image> images = imageService.saveImage(userHomeDir, req.getParts());
            image = images.stream().findFirst().get();
            temp.setUserImage("/iti-store/images/?imageId=" + image.getImageId());
        } else {
            temp.setUserImage(user.getUserImage());
        }

        if (user.equals(temp)) {
            try {
                throw new NoUpdatesException();
            } catch (NoUpdatesException e) {
                resp.sendRedirect("error.jsp");
                return;
            }
        } else {
            user.setFirstName(firstName);
            user.setPhone(phone);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setAddress(address);
            if (image != null) {
                user.setUserImage("/iti-store/images?imageId=" + image.getImageId());
            }
            userService.update(user, password);
        }
//        } catch (UserNotFoundException e) {
//            e.printStackTrace();
//        }
        resp.sendRedirect("view-profile");
    }
}