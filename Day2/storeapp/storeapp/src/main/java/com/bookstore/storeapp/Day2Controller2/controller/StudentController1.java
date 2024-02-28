package com.bookstore.storeapp.Day2Controller2.controller;

import org.springframework.web.bind.annotation.RestController;
import com.bookstore.storeapp.Day2Controller2.model.Student1;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StudentController1 {
    
    @PostMapping("/post")
    public Student1 postDetails(@RequestBody Student1 student) {
       System.out.println(student.getName());
       System.out.println(student.getAge());
       return student;
        
    }
    
}
