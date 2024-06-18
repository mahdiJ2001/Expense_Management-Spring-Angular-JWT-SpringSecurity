package com.expense_management.auth.service.impl;

import com.expense_management.auth.dto.AuthRequest;
import com.expense_management.auth.service.AuthService;
import com.expense_management.security.JwtUtil;
import com.expense_management.security.CustomUserDetailsService;
import com.expense_management.users.dto.UsersDto;
import com.expense_management.users.entity.Users;
import com.expense_management.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final UsersService usersService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           CustomUserDetailsService userDetailsService,
                           JwtUtil jwtUtil,
                           UsersService usersService,
                           PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.usersService = usersService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UsersDto registerUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersService.saveUser(user);
    }

    @Override
    public String createAuthToken(AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());
        return jwtUtil.generateToken(userDetails);
    }
}
