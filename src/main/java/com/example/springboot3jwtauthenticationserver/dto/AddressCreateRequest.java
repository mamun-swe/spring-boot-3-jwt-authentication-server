package com.example.springboot3jwtauthenticationserver.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddressCreateRequest {
    @NotBlank(message = "Country is required.")
    @NotEmpty(message = "Country is required.")
    @NotNull(message = "Country is required.")
    private String country;

    @NotBlank(message = "City is required.")
    @NotEmpty(message = "City is required.")
    @NotNull(message = "City is required.")
    private String city;

    @NotBlank(message = "Address is required.")
    @NotEmpty(message = "Address is required.")
    @NotNull(message = "Address is required.")
    private String address;
}
