package com.expense_management.category.service;

import com.expense_management.category.dto.CategoryDto;
import com.expense_management.category.entity.Category;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public interface CategoryService {
    Optional<CategoryDto> getCategoryById(int id);
    CategoryDto saveCategory(Category category);
    boolean deleteCategory(int id);
    CategoryDto updateCategory(int id, Category category);
    List<CategoryDto> getAllCategories();
}
