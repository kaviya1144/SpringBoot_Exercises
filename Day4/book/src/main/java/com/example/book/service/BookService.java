package com.example.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.model.Book;
import com.example.book.repository.BookRepo;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public Book postBook(Book book) {
        return bookRepo.save(book);
    }

    public List<Book> getBook() {
        return bookRepo.findAll();
    }

    public Book getBookById(int bookId) {
        return bookRepo.findById(bookId).orElse(null);
    }

    public Book putBook(int bookId, Book book) {
        Optional<Book> obj = bookRepo.findById(bookId);
        if (obj.isPresent()) {
            Book updated = obj.get();
            updated.setBookId(book.getBookId());
            updated.setBookName(book.getBookName());
            updated.setAuthor(book.getAuthor());

            return bookRepo.save(updated);
        } else {
            return null;
        }
    }

    public void deleteBook(int id) {
        bookRepo.deleteById(id);
    }
}
