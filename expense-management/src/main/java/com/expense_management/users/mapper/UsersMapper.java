package com.expense_management.users.mapper;

import com.expense_management.users.dto.UsersDto;
import com.expense_management.users.entity.Users;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UsersMapper {
    UsersDto toDto(Users entity);
    Users toEntity(UsersDto dto);
    List<UsersDto> toDtoList(List<Users> entity);
}
