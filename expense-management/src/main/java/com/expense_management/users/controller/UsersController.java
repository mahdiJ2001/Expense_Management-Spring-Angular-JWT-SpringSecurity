package com.expense_management.users.controller;

import com.expense_management.users.dto.UsersDto;
import com.expense_management.users.entity.Users;
import com.expense_management.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.MediaType;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UsersDto>> getUserById(@PathVariable int id) {
        Optional<UsersDto> userDto = usersService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsersDto> createUser(@RequestBody Users user) {
        UsersDto savedUserDto = usersService.saveUser(user);
        return ResponseEntity.ok(savedUserDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersDto> updateUser(@PathVariable int id, @RequestBody Users user) {
        UsersDto updatedUserDto = usersService.updateUser(id, user);
        return ResponseEntity.ok(updatedUserDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        usersService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UsersDto>> getAllUsers() {
        List<UsersDto> usersDtoList = usersService.getAllUsers();
        return ResponseEntity.ok(usersDtoList);
    }
}
