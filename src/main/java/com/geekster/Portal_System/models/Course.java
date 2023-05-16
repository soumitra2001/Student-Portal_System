package com.geekster.Portal_System.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @NotBlank
    @Pattern(regexp = "[A-Za-z\\D0-9]+")
    @Column(unique = true)
    private String courseTitle;

    @NotBlank
    @Pattern(regexp = "[A-Za-z\\D0-9]+")
    private String courseDescription;

    @NotBlank
    @Pattern(regexp = "[A-Za-z\\D0-9]+")
    private String courseDuration;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_all_student_id")
    private List<Student> students;

}
