package com.example.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.recipe.model.Recipe;
import java.util.List;


public interface RecipeRepo extends JpaRepository<Recipe,Integer>{
    
    @Query("Select r from Recipe r where r.recipeName = :value")
    List<Recipe> findRecipeName(String value);

}
