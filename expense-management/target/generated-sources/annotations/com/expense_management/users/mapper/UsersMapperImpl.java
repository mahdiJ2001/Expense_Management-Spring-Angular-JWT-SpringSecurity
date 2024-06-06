package com.expense_management.users.mapper;

import com.expense_management.users.dto.UsersDto;
import com.expense_management.users.entity.Users;
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
public class UsersMapperImpl implements UsersMapper {

    @Override
    public UsersDto toDto(Users entity) {
        if ( entity == null ) {
            return null;
        }

        UsersDto usersDto = new UsersDto();

        return usersDto;
    }

    @Override
    public Users toEntity(UsersDto dto) {
        if ( dto == null ) {
            return null;
        }

        Users users = new Users();

        return users;
    }

    @Override
    public List<UsersDto> toDtoList(List<Users> entity) {
        if ( entity == null ) {
            return null;
        }

        List<UsersDto> list = new ArrayList<UsersDto>( entity.size() );
        for ( Users users : entity ) {
            list.add( toDto( users ) );
        }

        return list;
    }
}
