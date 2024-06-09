package com.expense_management.category.mapper;

import com.expense_management.category.dto.CategoryDto;
import com.expense_management.category.entity.Category;
import com.expense_management.users.dto.UsersDto;
import com.expense_management.users.entity.Users;
import com.expense_management.users.mapper.UsersMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Category entity);
    Category toEntity(CategoryDto dto);
    @Mapping(target = "user", ignore = true)
    default UsersDto usersToUsersDto(Users users, UsersMapper userMapper) {
        return userMapper.toDto(users);
    }
    default Users usersDtoToUsers(UsersDto usersDto, UsersMapper userMapper) {
        return userMapper.toEntity(usersDto);
    }
    List<CategoryDto> toDtoList(List<Category> entityList);
    List<Category> toEntityList(List<CategoryDto> dtoList);
}
