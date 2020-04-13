package eg.gov.iti.jets.service.impl;

import eg.gov.iti.jets.model.Image;
import eg.gov.iti.jets.repository.ImageRepository;
import eg.gov.iti.jets.repository.impl.ImageRepositoryImpl;
import eg.gov.iti.jets.service.ImageService;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.*;

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
    public Set<Image> saveImage(String path, Collection<Part> parts) throws IOException {
//        String userHomeDir = System.getProperty("user.home");
//        String path = userHomeDir + File.separator + "Code.java";
//        String uploadPath = "/tmp/upload";
        File uploadDir = new File(path);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        Map<String , String> savedPaths = new HashMap<>(0);
        for (Part part : parts) {
            String fileName =null;
            String savePath = null;
            fileName = getFileName(part);
            if (fileName != null) {
                System.out.println(fileName);
                savePath = path + File.separator + fileName;
                part.write(savePath);
                savedPaths.put(fileName , savePath);
            }
        }
        Set<Image> images = new HashSet<>(0);
        savedPaths.forEach((key, value) -> {
            Image image = new Image();
            image.setImageName(key);
            image.setImagePath(value);
            image.setImageType("jpg");
            image = imageRepository.save(image);
            images.add(image);
        });

        return images;

    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return null;
    }
}
