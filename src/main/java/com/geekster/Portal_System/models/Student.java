package com.geekster.Portal_System.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @NotBlank
    @Pattern(regexp = "[A-Z][a-z]{2,10}\\D[A-Z][a-z]+")
    private String studentName;

    @Column(nullable = true)
    @Min(value = 10,message = "Student age must be greater than 9 years")
    private Integer studentAge;

    @NotBlank
    @Email
    @Column(unique = true)
    private String studentEmail;

    @NotBlank
    @Pattern(regexp = "[A-Za-z\\D0-9]+")
    private String studentPassword;

    @NotBlank
    @Column(nullable = true)
    @Pattern(regexp = "[0-9]{10,12}")
    private String studentPhNo;

    @Pattern(regexp = "[A-Za-z\\D0-9]+")
    @Nullable
    private String batchName;

    @NotBlank
    @Pattern(regexp = "[A-Za-z]+")
    private String studentDepartment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address_id")
    private Address address;

}
