package com.geekster.Portal_System.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;

    @NotBlank
    private String token;

    private LocalDate tokenCreationDate;

    @OneToOne
    @JoinColumn(name = "fk_student_id")
    private Student student;

    public AuthenticationToken(Student student) {
        this.student=student;
        this.tokenCreationDate=LocalDate.now();
        this.token= UUID.randomUUID().toString();
    }

}
