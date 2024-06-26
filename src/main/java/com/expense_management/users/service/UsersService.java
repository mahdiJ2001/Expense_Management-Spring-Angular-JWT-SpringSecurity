package com.expense_management.users.service;

import com.expense_management.users.dto.UsersDto;
import org.springframework.stereotype.Service;
import com.expense_management.users.entity.Users;

import java.util.Optional;
import java.util.List;

@Service
public interface UsersService {
    Optional<UsersDto> getUserById(int id);
    UsersDto saveUser(Users user);
    boolean deleteUser(int id);
    UsersDto updateUser(int id, Users user);
    List<UsersDto> getAllUsers();
    boolean emailExists(String email);

}
