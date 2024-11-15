package com.auth.Authentication.Services;

import com.auth.Authentication.entity.User;
import com.auth.Authentication.dto.RegisterRequest;
import com.auth.Authentication.dto.LoginRequest;

public interface UserService {
    User registerUser(RegisterRequest request);
    User findUserByUsername(String username);
    User authenticateUser(LoginRequest request); // Add this method
}