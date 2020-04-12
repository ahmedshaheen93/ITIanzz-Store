package eg.gov.iti.jets.service;

import eg.gov.iti.jets.model.Image;

import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;

public interface ImageService {
    Image findById(Long id);

    Set<Image> saveImage(String path, Collection<Part> parts) throws IOException;
}
