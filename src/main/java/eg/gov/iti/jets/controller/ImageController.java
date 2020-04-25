package eg.gov.iti.jets.controller;

import eg.gov.iti.jets.model.Image;
import eg.gov.iti.jets.service.ImageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "images", urlPatterns = "/images")
public class ImageController extends HttpServlet {

    private static final long serialVersionUID = 5461635420883008671L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String imageId = req.getParameter("imageId");
        ImageService imageService = (ImageService) getServletContext().getAttribute("imageService");
        Image image = imageService.findById(Long.parseLong(imageId));
        writeFileOnResponse(resp, image);

    }

    private void writeFileOnResponse(HttpServletResponse response, Image image) {
        try {
            File file = new File(image.getImagePath());
            PrintWriter out = response.getWriter();
            response.setContentType("APPLICATION/OCTET-STREAM");
            response.setHeader("Content-Disposition",
                    "attachment; filename=\"" + file.getName() + "\"");
            FileInputStream fileInputStream = new FileInputStream(file);
            int i;
            while ((i = fileInputStream.read()) != -1) {
                out.write(i);
            }
            fileInputStream.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
