package com.expense_management.expense.controller;

import com.expense_management.expense.entity.Expense;
import com.expense_management.expense.dto.ExpenseDto;
import com.expense_management.expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ExpenseDto>> getExpenseById(@PathVariable int id) {
        Optional<ExpenseDto> expenseDto = expenseService.getExpenseById(id);
        return ResponseEntity.ok(expenseDto);
    }

    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody Expense expense) {
        ExpenseDto savedExpenseDto = expenseService.saveExpense(expense);
        return ResponseEntity.ok(savedExpenseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable int id,@RequestBody Expense expense) {
        ExpenseDto updatedExpenseDto = expenseService.updateExpense(id, expense);
        return ResponseEntity.ok(updatedExpenseDto) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable int id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses() {
        List<ExpenseDto> expenseDtoList = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenseDtoList);
    }
}
