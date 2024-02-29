package com.example.person.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.person.model.Person;

public interface PersonRepo extends JpaRepository<Person,Integer>{
    

    @Query("Select a from Person a where age = :value")
    List<Person> findAge(int value);
}
