package com.expense_management.users.service.impl;

import com.expense_management.users.dto.UsersDto;
import com.expense_management.users.entity.Users;
import com.expense_management.users.mapper.UsersMapper;
import com.expense_management.users.repository.UsersRepository;
import com.expense_management.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.List;



public class UserServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository, UsersMapper usersMapper) {

        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
    }

    @Override
    public Optional<UsersDto> getUserById(int id) {
        Optional<Users> userOptional = usersRepository.findById(id);
        return userOptional.map(usersMapper::toDto);
    }

    @Override
    public UsersDto saveUser(Users user) {
        Users savedUser = usersRepository.save(user);
        return usersMapper.toDto(savedUser);
    }

    @Override
    public boolean deleteUser(int id) {
        if (usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
            return true;
        }
        throw new RuntimeException(" nonexistent id ");
    }

    @Override
    public UsersDto updateUser(int id, Users user) {
        if (usersRepository.existsById(id)) {
            Users updatedUser = usersRepository.save(user);
            return usersMapper.toDto(updatedUser);
        }
        throw new RuntimeException("User not found with id : " + id);
    }

    @Override
    public List<UsersDto> getAllUsers() {
        List<Users> users = usersRepository.findAll();
        return usersMapper.toDtoList(users);
    }
}