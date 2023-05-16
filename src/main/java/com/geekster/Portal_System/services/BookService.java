package com.geekster.Portal_System.services;

import com.geekster.Portal_System.models.Book;
import com.geekster.Portal_System.repositories.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    @Autowired
    IBookRepo bookRepo;
    public Book getBookByTitle(String bookName) {
        return bookRepo.findByBookTitle(bookName);
    }

    public void updateBookInfo(Book book) {
        bookRepo.save(book);
    }

    public List<Book> getAllBook() {
        return bookRepo.findAll();
    }


    public String postBook(Book book) {
        bookRepo.save(book);
        return "Book added successfully..!";
    }

    public String deleteBook(Long id) {
        bookRepo.deleteById(id);
        return "Book deleted!!";
    }
}
