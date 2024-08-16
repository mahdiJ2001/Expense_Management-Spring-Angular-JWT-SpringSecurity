package com.expense_management.report.dto;

import com.expense_management.expense.dto.ExpenseDto;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {
    private int id;
    private String type;
    private Date startDate;
    private Date endDate;
    private List<ExpenseDto> data;
}
