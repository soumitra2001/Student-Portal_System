package com.geekster.Portal_System.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
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
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long laptopId;

    @NotBlank
    @Column(unique = true)
    @Pattern(regexp = "[A-Za-z0-9\\D]+")
    private String laptopName;

    @NotBlank
    @Pattern(regexp = "[A-Za-z]+")
    private String laptopBrand;

    @Nullable
    @Min(value = 10000,message = "Laptop price can't be less than 10000/-")
    private Integer laptopPrice;

    @OneToOne
    @JoinColumn(name = "fk_student_id")
    private Student student;

}
