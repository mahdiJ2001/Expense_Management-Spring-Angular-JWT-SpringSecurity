package com.expense_management.auth.service;

import com.expense_management.auth.dto.AuthRequest;
import com.expense_management.users.dto.UsersDto;
import com.expense_management.users.entity.Users;

public interface AuthService {
    UsersDto registerUser(Users user);
    String createAuthToken(AuthRequest authRequest) throws Exception;
}
