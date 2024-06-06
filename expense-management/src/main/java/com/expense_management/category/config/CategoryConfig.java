package com.expense_management.category.config;

import com.expense_management.category.mapper.CategoryMapper;
import com.expense_management.category.repository.CategoryRepository;
import com.expense_management.category.service.CategoryService;
import com.expense_management.category.service.impl.CategoryServiceImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.expense_management.category.repository")
@EntityScan("com.expense_management.category.entity")
@ComponentScan("com.expense_management")
public class CategoryConfig {
    @Bean
    public CategoryService categoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        return new CategoryServiceImpl(categoryRepository, categoryMapper);
    }
}
