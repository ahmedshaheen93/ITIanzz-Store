package eg.gov.iti.jets.service.impl;

import eg.gov.iti.jets.model.Image;
import eg.gov.iti.jets.repository.ImageRepository;
import eg.gov.iti.jets.repository.impl.ImageRepositoryImpl;
import eg.gov.iti.jets.service.ImageService;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;

public class ImageServiceImpl implements ImageService {
    private static ImageServiceImpl instance;
    private ImageRepository imageRepository = ImageRepositoryImpl.getInstance();

    protected ImageServiceImpl() {
    }

    public static synchronized ImageServiceImpl getInstance() {
        instance = Objects.requireNonNullElseGet(instance, ImageServiceImpl::new);
        return instance;
    }

    @Override
    public Image findById(Long id) {
        return imageRepository.findById(id);
    }

    @Override
    public Image saveImage(String path, Collection<Part> parts) throws IOException {
//        String userHomeDir = System.getProperty("user.home");
//        String path = userHomeDir + File.separator + "Code.java";
//        String uploadPath = "/tmp/upload";
        File uploadDir = new File(path);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        String fileName = "file" + System.currentTimeMillis();
        String savePath = fileName;

        for (Part part : parts) {
            fileName = getFileName(part);
            System.out.println(fileName);
            savePath = path + File.separator + fileName;
            part.write(savePath);
        }
        Image image = new Image();
        image.setImageName(fileName);
        image.setImagePath(savePath);
        image.setImageType("jpg");
        return imageRepository.save(image);
//        image.setImageType();

//        FileInfo fileInfo = new FileInfo(fileName, uploadPath + File.separator + fileName);

    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return "file" + System.currentTimeMillis();
    }
}
