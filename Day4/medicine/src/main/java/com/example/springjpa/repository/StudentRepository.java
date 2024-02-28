package com.example.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springjpa.model.StudentDetails;

public interface StudentRepository extends JpaRepository <StudentDetails,Integer>{

    
}
