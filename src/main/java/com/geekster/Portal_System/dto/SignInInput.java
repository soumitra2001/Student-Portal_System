package com.geekster.Portal_System.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SignInInput {

    @NotBlank
    @Email
    private String userEmail;

    @NotBlank
    @Pattern(regexp = "[A-Za-z\\D0-9]+")
    private String password;

}
