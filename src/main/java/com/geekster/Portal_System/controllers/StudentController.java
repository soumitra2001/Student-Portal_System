package com.geekster.Portal_System.controllers;

import com.geekster.Portal_System.dto.SignInInput;
import com.geekster.Portal_System.dto.SignInOutput;
import com.geekster.Portal_System.dto.SignUpInput;
import com.geekster.Portal_System.dto.SignUpOutput;
import com.geekster.Portal_System.models.Book;
import com.geekster.Portal_System.models.Course;
import com.geekster.Portal_System.models.Laptop;
import com.geekster.Portal_System.models.Student;
import com.geekster.Portal_System.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/signup")
    public SignUpOutput signUp(@Valid @RequestBody SignUpInput signUpInput){
        return studentService.studentSignUp(signUpInput);
    }

    @PostMapping("/signin")
    public SignInOutput signIn(@Valid @RequestBody SignInInput signInInput){
        return studentService.studentSignIn(signInInput);
    }

    @PostMapping("/logout")
    public String logOut(@PathVariable String email){
        return studentService.logOutStudent(email);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> students=studentService.getAllStudent();
        return new ResponseEntity<>(students,students.isEmpty()? HttpStatus.NO_CONTENT:HttpStatus.OK);
    }

    @PutMapping("/{token}")
    public String updateStudent(@Valid @RequestBody Student student,@PathVariable String token){
        return studentService.updateStudentInfo(student,token);
    }

    @DeleteMapping("/{token}")
    public String deleteStudent(@PathVariable String token){
        return studentService.deleteStudentAccount(token);
    }

    @PostMapping("/course")
    public String buyCourse(@PathVariable String token,@PathVariable String courseName) throws NoSuchFieldException {
        return studentService.getMyCourse(token,courseName);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourse(){
        List<Course> courses=studentService.findAllCourse();

        return new ResponseEntity<>(courses,courses.isEmpty()?HttpStatus.NO_CONTENT:HttpStatus.OK);
    }

    @PostMapping("/book")
    public String buyBook(@PathVariable String token,@PathVariable String bookName) throws NoSuchFieldException {
        return studentService.getMyBook(token,bookName);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> availableBooks(){
        List<Book> books=studentService.findAllBook();

        return new ResponseEntity<>(books,books.isEmpty()?HttpStatus.NO_CONTENT:HttpStatus.OK);
    }

    @PostMapping("/laptop")
    public String buyLaptop(@PathVariable String token,@PathVariable String laptopName) throws NoSuchFieldException {
        return studentService.getMyLaptop(token,laptopName);
    }

    @GetMapping("/laptops")
    public ResponseEntity<List<Laptop>> availableLaptop(){
        List<Laptop> laptops=studentService.findAllLaptop();

        return new ResponseEntity<>(laptops,laptops.isEmpty()?HttpStatus.NO_CONTENT:HttpStatus.OK);
    }

}
