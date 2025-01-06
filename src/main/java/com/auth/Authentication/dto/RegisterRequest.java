package com.auth.Authentication.dto;

public class RegisterRequest {
    private String name;
    private String email; // New field for email
    private String password;
    private String role; // Role can be "COACH", "ATHLETE", or "ADMIN"

    // Getters and Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}