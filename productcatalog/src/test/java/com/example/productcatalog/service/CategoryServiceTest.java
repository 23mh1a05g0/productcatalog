package com.example.productcatalog.service;

import com.example.productcatalog.exception.ResourceNotFoundException;
import com.example.productcatalog.model.Category;
import com.example.productcatalog.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    void testGetCategoryById_Success() {
        Category category = new Category(1L, "Electronics");

        when(categoryRepository.findById(1L))
                .thenReturn(Optional.of(category));

        Category result = categoryService.getCategoryById(1L);

        assertEquals("Electronics", result.getName());
        verify(categoryRepository, times(1)).findById(1L);
    }

    @Test
    void testGetCategoryById_NotFound() {
        when(categoryRepository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () ->
                categoryService.getCategoryById(1L));
    }
}
