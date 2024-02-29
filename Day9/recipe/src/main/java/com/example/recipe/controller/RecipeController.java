package com.example.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.recipe.model.Recipe;
import com.example.recipe.service.RecipeService;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/recipe")
    public ResponseEntity<Recipe> post(@RequestBody Recipe recipe) {

        try {
            Recipe store = recipeService.postrecipe(recipe);
            return new ResponseEntity<>(store, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/recipe/{recipeId}")
    public ResponseEntity<Recipe> getById(@PathVariable int recipeId) {
        Recipe r = recipeService.getRecipeId(recipeId);
        if (r != null) {
            return new ResponseEntity<>(r, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/recipes/{byName}")
    public ResponseEntity<List<Recipe>> getName(@PathVariable("byName") String value) {
        List<Recipe> max = recipeService.getRName(value);
        if (max != null) {
            return new ResponseEntity<>(max, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
