package com.forgecommerce.category;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class) // Tells JUnit to use MockitoExtension for this class
public class CategoryServiceImplTest {

    @Mock // Creates a Mock of CategoryRepository
    private CategoryRepository categoryRepository;

    // Creates the actual CategoryServiceImpl object to test.
    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test // @Test tells JUnit that this method is a test case
    void createCategory(){

        // Arrange
        Category category = new Category();
        category.setName("Electronics");
        category.setDescription("Electrical products");
        when(categoryRepository.save(category)).thenReturn(category);

        // Act
        Category result = categoryService.createCategory(category);

        // Assert
        assertEquals(category,result);

        // Verify
        verify(categoryRepository).save(category);
    }

    @Test
    void getCategoryById(){

        //Arrange
        Long id = 1L;
        Category category = new Category();
        category.setName("Electronics");
        category.setDescription("Electrical products");
        when(categoryRepository.findById(id)).thenReturn(Optional.of(category));

        //Act
        Category category1 = categoryService.getCategoryById(id);

        //Assert
        assertEquals(category,category1);

        //Verify
        verify(categoryRepository).findById(id);
    }

    @Test
    void getCategoryById_NotFound(){

        //Act
        Long id = 1L;
        when(categoryRepository.findById(id)).thenReturn(Optional.empty());

        //Assert
        assertThrows(RuntimeException.class,()->{
            categoryService.getCategoryById(id);
        });

        //Verify
        verify(categoryRepository).findById(id);
    }


    @Test
    void getAllCategories(){

        //Act
        Category category1 = new Category();
        category1.setName("Electronics");
        category1.setDescription("Electrical products");
        Category category2 = new Category();
        category2.setName("Furniture");
        category2.setDescription("Beds, Sofas and Chairs");
        Category category3 = new Category();
        category3.setName("Edibles");
        category3.setDescription("Snacks and Beverages");

        List<Category> categoryList = List.of(category1, category2, category3);

        when(categoryRepository.findAll()).thenReturn(categoryList);

        List<Category> returnedCategories = categoryService.getAllCategories();

        //Assert
        assertEquals(categoryList,returnedCategories);

        //Verify
        verify(categoryRepository).findAll();
    }
}
