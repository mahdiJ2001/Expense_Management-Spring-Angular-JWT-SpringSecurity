package com.expense_management.budget.service.impl;

import com.expense_management.budget.dto.BudgetDto;
import com.expense_management.budget.entity.Budget;
import com.expense_management.budget.mapper.BudgetMapper;
import com.expense_management.budget.repository.BudgetRepository;
import com.expense_management.budget.service.BudgetService;
import com.expense_management.category.entity.Category;
import com.expense_management.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetServiceImpl implements BudgetService {
    private final BudgetRepository budgetRepository;
    private final BudgetMapper budgetMapper;
    private final CategoryRepository categoryRepository;

    @Autowired
    public BudgetServiceImpl(BudgetRepository budgetRepository, BudgetMapper budgetMapper, CategoryRepository categoryRepository) {
        this.budgetRepository = budgetRepository;
        this.budgetMapper = budgetMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<BudgetDto> getBudgetById(int id) {
        Optional<Budget> budgetOptional = budgetRepository.findById(id);
        return budgetOptional.map(budgetMapper::toDto);
    }

    @Override
    public BudgetDto saveBudget(Budget budget) {
        // Fetch the Category entity by its ID
        Category category = categoryRepository.findById(budget.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + budget.getCategory().getId()));

        // Set the fetched Category entity to the Budget entity
        budget.setCategory(category);

        // Save the Budget entity
        Budget savedBudget = budgetRepository.save(budget);
        return budgetMapper.toDto(savedBudget);
    }

    @Override
    public boolean deleteBudget(int id) {
        if (budgetRepository.existsById(id)) {
            budgetRepository.deleteById(id);
            return true;
        }
        throw new RuntimeException("Nonexistent budget with id: " + id);
    }

    @Override
    public BudgetDto updateBudget(int id, Budget budget) {
        if (budgetRepository.existsById(id)) {
            Budget updatedBudget = budgetRepository.save(budget);
            return budgetMapper.toDto(updatedBudget);
        }
        throw new RuntimeException("Budget not found with id: " + id);
    }

    @Override
    public List<BudgetDto> getAllBudgets() {
        List<Budget> budgets = budgetRepository.findAll();
        return budgetMapper.toDtoList(budgets);
    }
}
