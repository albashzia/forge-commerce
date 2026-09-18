package com.forgecommerce.category;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);

    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow() ;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        if (id.equals(category.getId())){
            Category updatableCategory = categoryRepository.findById(id).orElseThrow();
            updatableCategory.setName(category.getName());
            updatableCategory.setDescription(category.getDescription());
            return categoryRepository.save(updatableCategory);
            }
        throw new  IllegalArgumentException("Category ID doesn't match the given id");
    }

    @Override
    public void deleteCategory(Long id) {
        Category deletableCategory = categoryRepository.findById(id).orElseThrow();
        categoryRepository.delete(deletableCategory);
    }
}
