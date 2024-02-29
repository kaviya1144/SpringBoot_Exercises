package com.example.recipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recipe.model.Recipe;
import com.example.recipe.repository.RecipeRepo;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepo recipeRepo;

    public Recipe postrecipe(Recipe recipe) {
        return recipeRepo.save(recipe);
    }

    public Recipe getRecipeId(int recipeId)
   {
    return recipeRepo.findById(recipeId).orElse(null);
   }

   public List<Recipe> getRName(String value)
   {
    return recipeRepo.findRecipeName(value);
   }
}
