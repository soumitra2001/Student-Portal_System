package com.geekster.Portal_System.repositories;

import com.geekster.Portal_System.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepo extends JpaRepository<Student,Long> {

    Student findByStudentEmail(String emailId);

    Student getByStudentEmail(String userEmail);
}
