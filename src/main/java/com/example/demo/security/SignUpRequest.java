package com.example.demo.security;


import lombok.Data;

@Data
public class SignUpRequest {
    private String name;


    private String username;


    private String email;

    private String password;
}
