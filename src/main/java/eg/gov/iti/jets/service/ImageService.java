package eg.gov.iti.jets.service;

import eg.gov.iti.jets.model.Image;

import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;

public interface ImageService {
    Image findById(Long id);

    Image saveImage(String path, Collection<Part> parts) throws IOException;
}
