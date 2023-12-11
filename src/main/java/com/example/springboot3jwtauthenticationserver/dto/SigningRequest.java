package com.example.springboot3jwtauthenticationserver.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SigningRequest {
    @NotBlank(message = "Email is required.")
    @NotEmpty(message = "Email is required.")
    @NotNull(message = "Email is required.")
    private String email;

    @NotBlank(message = "Password is required.")
    @NotEmpty(message = "Password is required.")
    @NotNull(message = "Password is required.")
    private String password;
}
