package com.forgecommerce.category;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
}
