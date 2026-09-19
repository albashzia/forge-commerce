package com.forgecommerce.category;

import java.util.List;

public interface CategoryService {

    // Creates and saves a new category
    Category createCategory(Category category);

    // Retrieves a category by its ID
    Category getCategoryById(Long id);

    // Retrieves all categories
    List<Category> getAllCategories();

    // Updates an existing category identified by its ID
    Category updateCategory(Long id, Category category);

    // Deletes a category by its ID
    void deleteCategory(Long id);
}