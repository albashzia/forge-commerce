package com.forgecommerce.category;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    void createCategory(){
        Category category = new Category();
        category.setName("Electronics");
        category.setDescription("Electrical products");
        when(categoryRepository.save(category)).thenReturn(category);

        Category result = categoryService.createCategory(category);

        assertEquals(category,result);
        verify(categoryRepository).save(category);
    }
}
