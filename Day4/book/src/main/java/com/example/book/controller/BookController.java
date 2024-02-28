package com.example.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.model.Book;
import com.example.book.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/postbook")
    public ResponseEntity<Book> post(@RequestBody Book book) {

        try {
            Book store = bookService.postBook(book);
            return new ResponseEntity<>(store, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getbook")
    public ResponseEntity<List<Book>> get() {
        List<Book> li = bookService.getBook();
        if (li.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(li, HttpStatus.CREATED);
    }

    @GetMapping("/getbook/{bookId}")
    public ResponseEntity<Book> getById(@PathVariable int bookId) {
        Book b = bookService.getBookById(bookId);
        if (b != null) {
            return new ResponseEntity<>(b, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/putbook/{bookId}")
    public ResponseEntity<Book> put(@PathVariable int bookId, @RequestBody Book book) {

        Book save = bookService.putBook(bookId, book);
        if (save != null) {
            return new ResponseEntity<>(save, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/deletebook/{bookId}")
    public ResponseEntity<String> delete(@PathVariable("bookId") int bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok("Successfully deleted");
    }

}
