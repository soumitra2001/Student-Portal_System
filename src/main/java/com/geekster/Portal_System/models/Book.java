package com.geekster.Portal_System.models;

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
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @NotBlank
    @Column(unique = true)
    @Pattern(regexp = "[A-Za-z\\D0-9]+")
    private String bookTitle;

    @NotBlank
    @Pattern(regexp = "[A-Za-z\\D]+")
    private String bookAuthor;

    @Pattern(regexp = "[A-Za-z\\D0-9]+")
    private String bookDescription;

    @Min(value = 10,message = "Book price can not be greater than 10 rupees")
    private Double bookPrice;

    @ManyToOne
    @JoinColumn(name = "fk_student_id")
    private Student student;

}
