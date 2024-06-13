package com.expense_management.auth.controller;

import com.expense_management.security.JwtUtil;
import com.expense_management.security.CustomUserDetailsService;
import com.expense_management.auth.dto.AuthRequest;
import com.expense_management.users.dto.UsersDto;
import com.expense_management.users.entity.Users;
import com.expense_management.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsersService usersService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<UsersDto> registerUser(@RequestBody Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UsersDto savedUserDto = usersService.saveUser(user);
        return ResponseEntity.ok(savedUserDto);
    }


    @PostMapping("/login")
    public ResponseEntity<String> createAuthToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(jwt);
    }
}
