package com.example.demo.security;
import lombok.Data;

@Data
public class UserResponse {
    public UserResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    private Boolean success;
    private String message;
}