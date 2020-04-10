package eg.gov.iti.jets.repository.impl;

import eg.gov.iti.jets.model.Category;
import eg.gov.iti.jets.repository.CategoryRepository;

import java.util.Objects;

public class CategoryRepositoryImpl extends CrudImpl<Category, Long> implements CategoryRepository {
    private static CategoryRepositoryImpl instance;

    private CategoryRepositoryImpl() {
    }

    public static synchronized CategoryRepositoryImpl getInstance() {
        instance = Objects.requireNonNullElseGet(instance, CategoryRepositoryImpl::new);
        return instance;
    }
}
