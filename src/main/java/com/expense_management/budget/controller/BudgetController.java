package com.expense_management.budget.controller;

import com.expense_management.budget.dto.BudgetDto;
import com.expense_management.budget.entity.Budget;
import com.expense_management.budget.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.MediaType;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    private final BudgetService budgetService;

    @Autowired
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BudgetDto>> getBudgetById(@PathVariable int id) {
        Optional<BudgetDto> budgetDto = budgetService.getBudgetById(id);
        return ResponseEntity.ok(budgetDto);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BudgetDto> createBudget(@RequestBody Budget budget) {
        BudgetDto savedBudgetDto = budgetService.saveBudget(budget);
        return ResponseEntity.ok(savedBudgetDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BudgetDto> updateBudget(@PathVariable int id, @RequestBody Budget budget) {
        BudgetDto updatedBudgetDto = budgetService.updateBudget(id, budget);
        return ResponseEntity.ok(updatedBudgetDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBudget(@PathVariable int id) {
        budgetService.deleteBudget(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<BudgetDto>> getAllBudgets() {
        List<BudgetDto> budgetDtoList = budgetService.getAllBudgets();
        return ResponseEntity.ok(budgetDtoList);
    }
}
