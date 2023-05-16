package com.geekster.Portal_System.controllers;

import com.geekster.Portal_System.models.Book;
import com.geekster.Portal_System.models.Laptop;
import com.geekster.Portal_System.services.BookService;
import com.geekster.Portal_System.services.LaptopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop")
public class LaptopController {

    @Autowired
    LaptopService laptopService;

    @PostMapping
    public String addLaptop(@Valid @RequestBody Laptop laptop){
        return laptopService.postLaptop(laptop);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Laptop>> getAllLaptop(){
        List<Laptop> laptops=laptopService.getAllLaptop();

        return new ResponseEntity<>(laptops,laptops.isEmpty()? HttpStatus.NO_CONTENT:HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteLaptop(@PathVariable Long id){
        return laptopService.deleteLaptop(id);
    }
}
