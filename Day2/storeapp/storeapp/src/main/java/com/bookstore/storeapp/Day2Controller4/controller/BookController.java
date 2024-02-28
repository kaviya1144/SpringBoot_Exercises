package com.bookstore.storeapp.Day2Controller4.controller;

import org.springframework.web.bind.annotation.RestController;

import com.bookstore.storeapp.Day2Controller4.model.Book;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class BookController {
    
    @GetMapping("/book")
    public Book getDateMethod() {
        Book book = new Book("XYZ", "LMN",new Date());
        return book;

    }
    
}
