package com.expense_management.category.controller;

import com.expense_management.category.dto.CategoryDto;
import com.expense_management.category.entity.Category;
import com.expense_management.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CategoryDto>> getCategoryById(@PathVariable int id) {
        Optional<CategoryDto> categoryDto = categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryDto);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody Category category) {
        CategoryDto savedCategoryDto = categoryService.saveCategory(category);
        return ResponseEntity.ok(savedCategoryDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable int id, @RequestBody Category category) {
        CategoryDto updatedCategoryDto = categoryService.updateCategory(id, category);
        return ResponseEntity.ok(updatedCategoryDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categoriesDtoList = categoryService.getAllCategories();
        return ResponseEntity.ok(categoriesDtoList);
    }
}
