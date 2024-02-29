package com.example.studentpagesort.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentpagesort.model.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>{
    
}
