package eg.gov.iti.jets.service.impl;

import eg.gov.iti.jets.model.Category;
import eg.gov.iti.jets.repository.CategoryRepository;
import eg.gov.iti.jets.repository.impl.CategoryRepositoryImpl;
import eg.gov.iti.jets.service.CategoryService;

import java.util.List;
import java.util.Objects;

public class CategoryServiceImpl implements CategoryService {
    private static CategoryServiceImpl instance;
    CategoryRepository categoryRepository;

    protected CategoryServiceImpl() {
        this.categoryRepository = CategoryRepositoryImpl.getInstance();
    }

    public static synchronized CategoryServiceImpl getInstance() {
        instance = Objects.requireNonNullElseGet(instance, CategoryServiceImpl::new);
        return instance;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
