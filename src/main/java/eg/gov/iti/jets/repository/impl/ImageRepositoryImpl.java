package eg.gov.iti.jets.repository.impl;

import eg.gov.iti.jets.model.Image;

import java.util.Objects;

public class ImageRepositoryImpl extends CrudImpl<Image, Long> {

    private static ImageRepositoryImpl instance;

    public static synchronized ImageRepositoryImpl getInstance() {
        return Objects.requireNonNullElseGet(instance,
                () -> {
                    instance = new ImageRepositoryImpl();
                    return instance;
                });
    }
}
