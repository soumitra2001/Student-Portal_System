package com.geekster.Portal_System.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Pattern(regexp = "[A-Za-z\\D]+")
    private String landmark;

    @Pattern(regexp = "[0-9]{4,10}")
    private String zipcode;

    @NotBlank
    @Pattern(regexp = "[A-Za-z]+")
    private String district;

    @NotBlank
    @Pattern(regexp = "[A-Za-z]+")
    private String state;

    @NotBlank
    @Pattern(regexp = "[A-Za-z]+")
    private String country;

}
