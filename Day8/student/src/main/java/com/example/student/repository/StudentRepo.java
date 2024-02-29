package com.example.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.student.model.Student;

public interface StudentRepo extends JpaRepository<Student,Long>{
    
    @Query("Select s from Student s where marks > :value")
    List<Student> findByMaxMarks(@Param ("value") int value);

    @Query("Select s from Student s where marks < :value")
    List<Student> findByMinMarks(@Param ("value") int value);
}
