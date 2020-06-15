package com.example.demo.dto;

import lombok.Data;

@Data
public class SignUpDto {
    private String login;
    private String password;
    private String passwordRepeat;
}

