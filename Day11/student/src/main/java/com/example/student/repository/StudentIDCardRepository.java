package com.example.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student.model.StudentIDCard;

public interface StudentIDCardRepository extends JpaRepository<StudentIDCard, Long> {
    // Custom queries if needed
}