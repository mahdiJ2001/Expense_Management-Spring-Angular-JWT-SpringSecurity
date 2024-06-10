package com.expense_management.expense.mapper;

import com.expense_management.category.mapper.CategoryMapper;
import com.expense_management.expense.dto.ExpenseDto;
import com.expense_management.expense.entity.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ExpenseMapper {
    @Mapping(target = "categoryId", source = "category.id")
    ExpenseDto toDto(Expense entity);
    Expense toEntity(ExpenseDto dto);
    List<ExpenseDto> toDtoList(List<Expense> entity);
}
