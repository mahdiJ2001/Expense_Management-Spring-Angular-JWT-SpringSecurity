package com.expense_management.expense.dto;

import com.expense_management.category.dto.CategoryDto;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDto {
    private int id;
    private float amount;
    private CategoryDto category;
    private Date date;
    private String note;
}
