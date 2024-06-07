package com.expense_management.users.mapper;

import com.expense_management.users.dto.UsersDto;
import com.expense_management.users.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UsersMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phone", target = "phone")
    UsersDto toDto(Users entity);
    Users toEntity(UsersDto dto);
    List<UsersDto> toDtoList(List<Users> entity);
}
