package com.forgecommerce.category;

import org.springframework.stereotype.Service;

import java.util.List;

@Service // Make this class as service component
public class CategoryServiceImpl implements CategoryService{

    // Repository used to perform database operations on Category entities
    private final CategoryRepository categoryRepository;

    // Constructor injection is used to provide the required CategoryRepository dependency
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    // Creates a new category and saves it to the database
    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);

    }

    // Finds and returns a category by its ID
    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow() ;
    }

    // Retrieves and returns all categories from the database
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Updates an existing category after verifying that the provided IDs match
    @Override
    public Category updateCategory(Long id, Category category) {

        // Ensures that the provided ID matches the ID of the category being updated
        if (id.equals(category.getId())){

            // Finds the existing category that will be updated
            Category updatableCategory = categoryRepository.findById(id).orElseThrow();

            // Updates only the fields that are allowed to be changed
            updatableCategory.setName(category.getName());
            updatableCategory.setDescription(category.getDescription());

            // Saves and returns the updated category
            return categoryRepository.save(updatableCategory);
            }
        throw new  IllegalArgumentException("Category ID doesn't match the given id");
    }

    // Finds the category by ID and deletes it from the database
    @Override
    public void deleteCategory(Long id) {

        // Finds the category that will be deleted
        Category deletableCategory = categoryRepository.findById(id).orElseThrow();

        // Deletes the retrieved category from the database
        categoryRepository.delete(deletableCategory);
    }
}
