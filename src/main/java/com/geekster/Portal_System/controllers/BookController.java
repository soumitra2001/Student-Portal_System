package com.geekster.Portal_System.controllers;

import com.geekster.Portal_System.models.Book;
import com.geekster.Portal_System.models.Course;
import com.geekster.Portal_System.repositories.ICourseRepo;
import com.geekster.Portal_System.services.BookService;
import com.geekster.Portal_System.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping
    public String addBook(@Valid @RequestBody Book book){
        return bookService.postBook(book);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBook(){
        List<Book> books=bookService.getAllBook();

        return new ResponseEntity<>(books,books.isEmpty()? HttpStatus.NO_CONTENT:HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id){
        return bookService.deleteBook(id);
    }

}
