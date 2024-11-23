package com.auth.Authentication.Controller;

import com.auth.Authentication.dto.AuthResponse;
import com.auth.Authentication.dto.LoginRequest;
import com.auth.Authentication.dto.RegisterRequest;
import com.auth.Authentication.entity.User;
import com.auth.Authentication.Services.UserService;
import com.auth.Authentication.security.JwtTokenProvider; // Import JWT utility class
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider; // Inject JWT utility

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        User user = userService.registerUser(request);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        // Authenticate the user
        User user = userService.authenticateUser(request);

        // Generate JWT token
        String token = jwtTokenProvider.generateToken(user.getUsername());

        // Create a response message
        String message = "Login successful for user: " + user.getUsername();

        // Return token and message in response
        return ResponseEntity.ok(new AuthResponse(token, message)); // Create an AuthResponse class to hold the token and message
    }
}