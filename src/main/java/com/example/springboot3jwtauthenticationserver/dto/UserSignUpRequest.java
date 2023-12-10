package com.example.springboot3jwtauthenticationserver.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserSignUpRequest {
    @NotBlank(message = "Name is required.")
    @NotEmpty(message = "Name is required.")
    @NotNull(message = "Name is required.")
    private String name;

    @NotBlank(message = "Email is required.")
    @NotEmpty(message = "Email is required.")
    @NotNull(message = "Email is required.")
    private String email;

    @NotBlank(message = "Password is required.")
    @NotEmpty(message = "Password is required.")
    @NotNull(message = "Password is required.")
    private String password;
}
