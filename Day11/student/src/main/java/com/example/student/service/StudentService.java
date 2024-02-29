package com.example.student.service;
import java.util.List;

import com.example.student.model.Student;

public interface StudentService {
    Student createStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long studentId);
    Student updateStudent(Long studentId, Student student);
    void deleteStudent(Long studentId);
}