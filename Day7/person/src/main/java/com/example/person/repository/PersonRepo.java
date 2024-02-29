package com.example.person.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.person.model.Person;

public interface PersonRepo extends JpaRepository<Person,Integer>{
    
    List<Person> findByAge(int age);
}
