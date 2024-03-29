package com.example.language.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.language.model.Language;



@Repository
public interface LanguageRepo extends JpaRepository<Language, Integer> {

}
