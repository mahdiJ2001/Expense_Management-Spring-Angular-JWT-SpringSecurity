package com.expense_management.report.mapper;

import com.expense_management.expense.mapper.ExpenseMapper;
import com.expense_management.report.dto.ReportDto;
import com.expense_management.report.entity.Report;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ExpenseMapper.class)
public interface ReportMapper {

    ReportDto toDto(Report entity);
    List<ReportDto> toDtoList(List<Report> entityList);
    Report toEntity(ReportDto dto);
    List<Report> toEntityList(List<ReportDto> dtoList);
}
