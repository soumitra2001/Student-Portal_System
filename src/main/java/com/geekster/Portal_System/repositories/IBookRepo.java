package com.geekster.Portal_System.repositories;

import com.geekster.Portal_System.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepo extends JpaRepository<Book,Long> {

    Book findByBookTitle(String bookTitle);
}
