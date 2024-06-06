package com.expense_management.category.mapper;

import com.expense_management.category.dto.CategoryDto;
import com.expense_management.category.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Category entity);
    Category toEntity(CategoryDto dto);
    List<CategoryDto> toDtoList(List<Category> entityList);
    List<Category> toEntityList(List<CategoryDto> dtoList);
}
