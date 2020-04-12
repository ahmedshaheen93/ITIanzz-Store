package eg.gov.iti.jets.repository.impl;

import eg.gov.iti.jets.model.Image;
import eg.gov.iti.jets.repository.ImageRepository;

import java.util.Objects;

public class ImageRepositoryImpl extends CrudImpl<Image, Long> implements ImageRepository {
    private static ImageRepositoryImpl instance;

    private ImageRepositoryImpl() {
    }

    public static synchronized ImageRepositoryImpl getInstance() {
        instance = Objects.requireNonNullElseGet(instance, ImageRepositoryImpl::new);
        return instance;
    }
}
