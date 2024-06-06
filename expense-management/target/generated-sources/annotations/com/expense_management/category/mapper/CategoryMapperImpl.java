package com.expense_management.category.mapper;

import com.expense_management.category.dto.CategoryDto;
import com.expense_management.category.entity.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-06T15:51:11+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDto toDto(Category entity) {
        if ( entity == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        return categoryDto;
    }

    @Override
    public Category toEntity(CategoryDto dto) {
        if ( dto == null ) {
            return null;
        }

        Category category = new Category();

        return category;
    }

    @Override
    public List<CategoryDto> toDtoList(List<Category> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( entityList.size() );
        for ( Category category : entityList ) {
            list.add( toDto( category ) );
        }

        return list;
    }

    @Override
    public List<Category> toEntityList(List<CategoryDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( dtoList.size() );
        for ( CategoryDto categoryDto : dtoList ) {
            list.add( toEntity( categoryDto ) );
        }

        return list;
    }
}
