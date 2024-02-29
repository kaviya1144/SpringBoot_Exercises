package com.example.person.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.person.model.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

    @Query("SELECT p FROM Person p WHERE p.name LIKE CONCAT(:value, '%')")
    List<Person> findByStartWithName(@Param("value") String value);


    @Query("SELECT p FROM Person p WHERE p.name LIKE CONCAT('%' , :value)")
    List<Person> findByEndWithName(@Param("value") String value);

}
