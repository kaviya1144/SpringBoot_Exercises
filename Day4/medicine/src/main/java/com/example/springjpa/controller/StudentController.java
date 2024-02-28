package com.example.springjpa.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.springjpa.model.StudentDetails;
import com.example.springjpa.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @PostMapping("/jpastudent")
    public StudentDetails postStudent(@RequestBody StudentDetails studentDetails) {    
        return studentService.savStudent(studentDetails);
    }

    
}
