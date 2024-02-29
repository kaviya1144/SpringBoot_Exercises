package com.example.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepo;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Student poststudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getMaxmarks(int value) {
        return studentRepo.findByMaxMarks(value);
    }

    public List<Student> getMinmarks(int value) {
        return studentRepo.findByMaxMarks(value);
    }

}
