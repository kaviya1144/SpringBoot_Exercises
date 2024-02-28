package com.bookstore.storeapp.Day2Controller3.controller;

import org.springframework.web.bind.annotation.RestController;

import com.bookstore.storeapp.Day2Controller3.model.Student;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class StudentController {

    @GetMapping("/stu")
    public Student getVal() {
        Student st = new Student(83, "Kaviya", "good");
        return st;
    }
    
}
