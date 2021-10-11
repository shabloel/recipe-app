package com.shabloel.recipeapp.controller;

import com.shabloel.recipeapp.model.Recipe;
import com.shabloel.recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


/**
 * @author christiaan.griffioen on feb, 2021
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class RecipeController {

    Logger logger = LoggerFactory.getLogger(RecipeController.class);

    private final RecipeService recipeSer;

    @Autowired
    public RecipeController(RecipeService recipeSer) {
        this.recipeSer = recipeSer;
    }

    @GetMapping({"", "/", "/index", "/recipes"})
    public Set<Recipe> getRecipes() {
        logger.info("Getting the recipes");
        return recipeSer.getRecipes();
    }

    @GetMapping("/recipes/{id}")
    public Recipe getRecipeById(@RequestParam Long id) {
        logger.info("Getting the recipe with id " + id);
        return recipeSer.getRecipeById(id);
    }

    @PostMapping("/newrecipe")
    public void saveRecipe(@RequestBody Recipe recipe) {
        logger.info("Adding new recipe");
        recipeSer.addNewRecipe(recipe);
    }

    @DeleteMapping("/{recipeId}")
    public void deleteRecipe(@PathVariable("recipeId") Long id) {
        logger.info("deleting Recipe with id " + id);
        recipeSer.deleteRecipe(id);
    }
}
