package com.example.productcatalog.controller;

import com.example.productcatalog.dto.CategoryRequestDTO;
import com.example.productcatalog.dto.CategoryResponseDTO;
import com.example.productcatalog.model.Category;
import com.example.productcatalog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(
            @Valid @RequestBody CategoryRequestDTO requestDTO) {

        Category category = Category.builder()
                .name(requestDTO.getName())
                .build();

        Category saved = categoryService.createCategory(category);

        CategoryResponseDTO responseDTO = CategoryResponseDTO.builder()
                .id(saved.getId())
                .name(saved.getName())
                .build();

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {

        List<CategoryResponseDTO> categories = categoryService.getAllCategories()
                .stream()
                .map(category -> CategoryResponseDTO.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable Long id) {

        Category category = categoryService.getCategoryById(id);

        CategoryResponseDTO responseDTO = CategoryResponseDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();

        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(
            @PathVariable Long id,
            @Valid @RequestBody CategoryRequestDTO requestDTO) {

        Category updated = Category.builder()
                .name(requestDTO.getName())
                .build();

        Category saved = categoryService.updateCategory(id, updated);

        CategoryResponseDTO responseDTO = CategoryResponseDTO.builder()
                .id(saved.getId())
                .name(saved.getName())
                .build();

        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {

        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
