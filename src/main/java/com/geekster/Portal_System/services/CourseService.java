package com.geekster.Portal_System.services;

import com.geekster.Portal_System.models.Course;
import com.geekster.Portal_System.repositories.ICourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {


    @Autowired
    ICourseRepo courseRepo;
    public Course getCourse(String courseName) {
        return courseRepo.getByCourseTitle(courseName);
    }

    public String  updateCourseStudentList(Course course) {
        courseRepo.save(course);
        return "Course updated...!";
    }

    public List<Course> getAllCourse() {
        return courseRepo.findAll();
    }

    public String postCourse(Course course) {
        Course addedCourse = courseRepo.save(course);
        if(addedCourse==null)return "Course have not added..!";
        return "Course added successfully..!";
    }

    public String deleteCourse(Long id) {
        courseRepo.deleteById(id);
        return "Course successfully deleted..!";
    }
}
