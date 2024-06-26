package com.expense_management.expense.service;

import com.expense_management.expense.entity.Expense;
import com.expense_management.expense.dto.ExpenseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ExpenseService {
    Optional<ExpenseDto> getExpenseById(int id);
    ExpenseDto saveExpense(Expense expense);
    boolean deleteExpense(int id);
    ExpenseDto updateExpense(int id, Expense expense);
    List<ExpenseDto> getAllExpenses();
    List<Expense> getExpensesByUserId(int userId);
}
