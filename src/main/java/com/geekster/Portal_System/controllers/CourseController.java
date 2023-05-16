package com.geekster.Portal_System.controllers;

import com.geekster.Portal_System.models.Course;
import com.geekster.Portal_System.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping
    public String addCourse(@Valid @RequestBody Course course){
        return courseService.postCourse(course);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourse(){
        List<Course> courses=courseService.getAllCourse();

        return new ResponseEntity<>(courses,courses.isEmpty()? HttpStatus.NO_CONTENT:HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id){
        return courseService.deleteCourse(id);
    }

}
