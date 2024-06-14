package com.expense_management.expense.service.impl;

import com.expense_management.expense.dto.ExpenseDto;
import com.expense_management.expense.entity.Expense;
import com.expense_management.expense.mapper.ExpenseMapper;
import com.expense_management.expense.repository.ExpenseRepository;
import com.expense_management.expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository, ExpenseMapper expenseMapper) {
        this.expenseRepository = expenseRepository;
        this.expenseMapper = expenseMapper;
    }

    @Override
    public Optional<ExpenseDto> getExpenseById(int id) {
        return expenseRepository.findById(id).map(expenseMapper::toDto);
    }

    @Override
    public ExpenseDto saveExpense(Expense expense) {
        Expense savedExpense = expenseRepository.save(expense);
        return expenseMapper.toDto(savedExpense);
    }

    @Override
    public boolean deleteExpense(int id) {
        if (expenseRepository.existsById(id)) {
            expenseRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ExpenseDto updateExpense(int id, Expense expense) {
        if (expenseRepository.existsById(id)) {
            expense.setId(id);
            Expense updatedExpense = expenseRepository.save(expense);
            return expenseMapper.toDto(updatedExpense);
        }
        return null;
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream()
                .map(expenseMapper::toDto)
                .collect(Collectors.toList());
    }
}
