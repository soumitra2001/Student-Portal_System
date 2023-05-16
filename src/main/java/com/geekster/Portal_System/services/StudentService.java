package com.geekster.Portal_System.services;

import com.geekster.Portal_System.dto.SignInInput;
import com.geekster.Portal_System.dto.SignInOutput;
import com.geekster.Portal_System.dto.SignUpInput;
import com.geekster.Portal_System.dto.SignUpOutput;
import com.geekster.Portal_System.models.*;
import com.geekster.Portal_System.repositories.IStudentRepo;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    IStudentRepo studentRepo;

    @Autowired
    AuthenticationService authService;

    @Autowired
    CourseService courseService;

    @Autowired
    BookService bookService;

    @Autowired
    LaptopService laptopService;

    @SneakyThrows
    public SignUpOutput studentSignUp(SignUpInput signUpInput) {
        // Check if the User is already exists or not
        Student student = studentRepo.findByStudentEmail(signUpInput.getEmailId());

        if(student!=null){
            throw new IllegalAccessException("Student already exists..SignIn instead");
        }

        // Encrypted the password
        String encryptedPassword=null;
        try {
            encryptedPassword=encryptMyPassword(signUpInput.getPassword());
        }catch (Exception e){
            e.printStackTrace();
        }

        //Creation of a user Object
        student = new Student();

        //Save User in DB
        studentRepo.save(student);

        //Return SigUp output
        return new SignUpOutput("Student's account created successfully..!", HttpStatus.CREATED);

    }

    private String encryptMyPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(password.getBytes());
        byte[] digested = md5.digest();

        String hash="";
        for(byte val:digested){
            hash += String.format("%02X",val);
        }
        return hash;
    }

    public SignInOutput studentSignIn(SignInInput signInInput) {
        Student student = studentRepo.getByStudentEmail(signInInput.getUserEmail());

        if(student==null){
            throw new IllegalArgumentException("Invalid UserName or Password..!");
        }

        String encryptedPassword=null;
        try {
            encryptedPassword = encryptMyPassword(signInInput.getPassword());
        }catch (Exception e){
            e.printStackTrace();
        }
        boolean isCorrectPassword=student.getStudentPassword().equals(encryptedPassword);

        if(!isCorrectPassword){
            throw new IllegalArgumentException("Invalid UserName or Password..!");
        }

        //Save User Authentication Info into Authentication-Token Table
        AuthenticationToken token=new AuthenticationToken(student);
        authService.saveToken(token);

        return new SignInOutput("User LogIn successful..!",token.getToken());

    }


    public String logOutStudent(String email) {
        List<Student> students=studentRepo.findAll();
        for(Student student:students){
            if(student.getStudentEmail().equals(email)){
                authService.deleteTokenByStudent(student);
                return "Student logOut successful..!";
            }
        }

        return "Invalid user input..!";
    }

    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @Transactional
    public String updateStudentInfo(Student newStudent, String token) {
        deleteStudentAccount(token);
        studentRepo.save(newStudent);

        return "Student Info updated successfully...!";
    }


    @Transactional
    public String deleteStudentAccount(String token) {
        Student student=getStudentByAuthenticateToken(token);
        studentRepo.deleteById(student.getStudentId());

        return "Account deleted successfully..!";
    }

    private Student getStudentByAuthenticateToken(String token) {
        AuthenticationToken authToken=authService.findToken(token);
        if(authToken==null)throw new IllegalStateException("Invalid user..!");

        Student student=authToken.getStudent();
        return student;
    }


    @Transactional
    public String getMyCourse(String token, String courseName) throws NoSuchFieldException {
        Student student=getStudentByAuthenticateToken(token);

        Course course=courseService.getCourse(courseName);

        if(course==null)throw new NoSuchFieldException("No course available named: "+courseName);

        List<Student> enrolledStudent=course.getStudents();

        enrolledStudent.add(student);

        courseService.updateCourseStudentList(course);
        return "Congratulations!!...You have successfully enroll this course.";
    }


    public List<Course> findAllCourse() {
        return courseService.getAllCourse();
    }


    @Transactional
    public String getMyBook(String token, String bookName) throws NoSuchFieldException {
        Student student=getStudentByAuthenticateToken(token);

        Book book=bookService.getBookByTitle(bookName);

        if(book==null)throw new NoSuchFieldException("No book available named: "+bookName);

        Student student1=book.getStudent();
        if(student1!=null){
            return "Sorry..This book is not available now!";
        }

        book.setStudent(student);

        bookService.updateBookInfo(book);

        return "Congratulations!!...Book purchase successful..!";
    }


    public List<Book> findAllBook() {
        return bookService.getAllBook();
    }


    @Transactional
    public String getMyLaptop(String token, String laptopName) throws NoSuchFieldException {
        Student student=getStudentByAuthenticateToken(token);

        Laptop laptop=laptopService.getLaptopByName(laptopName);

        if(laptop==null)throw new NoSuchFieldException("No Laptop available named: "+laptopName);

        Student student1=laptop.getStudent();
        if(student1!=null){
            return "This laptop has been sold out..!";
        }

        laptop.setStudent(student);

        laptopService.updateLaptopInfo(laptop);

        return "Congratulations!!...Laptop purchase successful..!";
    }

    public List<Laptop> findAllLaptop() {
        return laptopService.getAllLaptop();
    }
}
