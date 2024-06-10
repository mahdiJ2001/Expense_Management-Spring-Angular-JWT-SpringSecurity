package com.expense_management.budget.dto;

import com.expense_management.category.dto.CategoryDto;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BudgetDto {
    private int id;
    private float amount;
    private Integer categoryId;
    private String period;
    private float spentAmount;
}
