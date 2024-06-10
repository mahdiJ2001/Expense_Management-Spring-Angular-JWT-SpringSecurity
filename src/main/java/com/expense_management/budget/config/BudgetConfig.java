package com.expense_management.budget.config;

import com.expense_management.budget.mapper.BudgetMapper;
import com.expense_management.budget.repository.BudgetRepository;
import com.expense_management.budget.service.BudgetService;
import com.expense_management.budget.service.impl.BudgetServiceImpl;
import com.expense_management.category.repository.CategoryRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.expense_management.budget.repository")
@EntityScan("com.expense_management.budget.entity")
@ComponentScan("com.expense_management")
public class BudgetConfig {
    @Bean
    public BudgetService budgetService(BudgetRepository budgetRepository, BudgetMapper budgetMapper , CategoryRepository categoryRepository) {
        return new BudgetServiceImpl(budgetRepository, budgetMapper ,categoryRepository );
    }
}
