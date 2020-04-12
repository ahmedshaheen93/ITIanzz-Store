package eg.gov.iti.jets.service;

import eg.gov.iti.jets.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
}
