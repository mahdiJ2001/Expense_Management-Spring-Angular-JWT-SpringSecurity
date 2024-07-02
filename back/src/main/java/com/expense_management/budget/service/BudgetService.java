package com.expense_management.budget.service;

import com.expense_management.budget.dto.BudgetDto;
import com.expense_management.budget.entity.Budget;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public interface BudgetService {
    Optional<BudgetDto> getBudgetById(int id);
    BudgetDto saveBudget(Budget budget);
    boolean deleteBudget(int id);
    BudgetDto updateBudget(int id, Budget budget);
    List<BudgetDto> getAllBudgets();
}
