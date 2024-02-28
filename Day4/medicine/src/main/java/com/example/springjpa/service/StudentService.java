package com.example.springjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springjpa.model.StudentDetails;
import com.example.springjpa.repository.StudentRepository;

@Service
public class StudentService {
    
    private StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    public StudentDetails savStudent(StudentDetails studentDetails){
        return studentRepository.save(studentDetails);

    }
}
