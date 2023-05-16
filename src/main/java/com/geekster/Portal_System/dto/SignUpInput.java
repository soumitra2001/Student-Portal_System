package com.geekster.Portal_System.dto;

import com.geekster.Portal_System.models.Address;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SignUpInput {

    @NotBlank
    @Pattern(regexp = "[A-Z][a-z]+")
    private String userName;

    @NotBlank
    @Pattern(regexp = "[A-Za-z]+")
    private String userDepartment;

    @NotBlank
    @Email
    private String emailId;

    @NotBlank
    @Pattern(regexp = "[A-Za-z\\D0-9]+")
    private String password;

    @Embedded
    private Address userAddress;

}
