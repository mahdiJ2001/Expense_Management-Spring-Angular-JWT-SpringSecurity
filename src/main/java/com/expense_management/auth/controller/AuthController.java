package com.expense_management.auth.controller;

import com.expense_management.auth.dto.AuthRequest;
import com.expense_management.users.dto.UsersDto;
import com.expense_management.users.entity.Users;
import com.expense_management.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UsersDto> registerUser(@RequestBody Users user) {
        UsersDto savedUserDto = authService.registerUser(user);
        return ResponseEntity.ok(savedUserDto);
    }

    @PostMapping("/login")
    public ResponseEntity<String> createAuthToken(@RequestBody AuthRequest authRequest) throws Exception {
        String jwt = authService.createAuthToken(authRequest);
        return ResponseEntity.ok(jwt);
    }
}
