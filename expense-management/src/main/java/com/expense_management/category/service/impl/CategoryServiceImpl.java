package com.expense_management.category.service.impl;

import com.expense_management.category.dto.CategoryDto;
import com.expense_management.category.entity.Category;
import com.expense_management.category.mapper.CategoryMapper;
import com.expense_management.category.repository.CategoryRepository;
import com.expense_management.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Optional<CategoryDto> getCategoryById(int id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toDto);
    }

    @Override
    public CategoryDto saveCategory(Category category) {
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toDto(savedCategory);
    }

    @Override
    public boolean deleteCategory(int id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public CategoryDto updateCategory(int id, Category category) {
        if (categoryRepository.existsById(id)) {
            Category updatedCategory = categoryRepository.save(category);
            return categoryMapper.toDto(updatedCategory);
        }
        throw new RuntimeException("Category not found");
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }
}
