package com.geekster.Portal_System.repositories;

import com.geekster.Portal_System.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepo extends JpaRepository<Course,Long> {

    Course getByCourseTitle(String courseName);
}
