package com.expense_management.users.mapper;

import com.expense_management.users.dto.UsersDto;
import com.expense_management.users.entity.Users;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-07T12:29:43+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class UsersMapperImpl implements UsersMapper {

    @Override
    public UsersDto toDto(Users entity) {
        if ( entity == null ) {
            return null;
        }

        UsersDto.UsersDtoBuilder usersDto = UsersDto.builder();

        usersDto.id( entity.getId() );
        usersDto.firstName( entity.getFirstName() );
        usersDto.lastName( entity.getLastName() );
        usersDto.email( entity.getEmail() );
        usersDto.phone( entity.getPhone() );

        return usersDto.build();
    }

    @Override
    public Users toEntity(UsersDto dto) {
        if ( dto == null ) {
            return null;
        }

        Users.UsersBuilder users = Users.builder();

        users.id( dto.getId() );
        users.firstName( dto.getFirstName() );
        users.lastName( dto.getLastName() );
        users.email( dto.getEmail() );
        users.phone( dto.getPhone() );

        return users.build();
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
