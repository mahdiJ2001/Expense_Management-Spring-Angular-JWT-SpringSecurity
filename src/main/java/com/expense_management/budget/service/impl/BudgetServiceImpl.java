package com.expense_management.budget.service.impl;

import com.expense_management.budget.dto.BudgetDto;
import com.expense_management.budget.entity.Budget;
import com.expense_management.budget.mapper.BudgetMapper;
import com.expense_management.budget.repository.BudgetRepository;
import com.expense_management.budget.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class BudgetServiceImpl implements BudgetService {
    private final BudgetRepository budgetRepository;
    private final BudgetMapper budgetMapper;

    @Autowired
    public BudgetServiceImpl(BudgetRepository budgetRepository, BudgetMapper budgetMapper) {
        this.budgetRepository = budgetRepository;
        this.budgetMapper = budgetMapper;
    }

    @Override
    public Optional<BudgetDto> getBudgetById(int id) {
        Optional<Budget> budgetOptional = budgetRepository.findById(id);
        return budgetOptional.map(budgetMapper::toDto);
    }

    @Override
    public BudgetDto saveBudget(Budget budget) {
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
