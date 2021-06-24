package com.shabloel.recipeapp.controller;

import com.shabloel.recipeapp.model.Recipe;
import com.shabloel.recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
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

    private final RecipeService recipeSer;

    @Autowired
    public RecipeController(RecipeService recipeSer) {
        this.recipeSer = recipeSer;
    }

    @GetMapping({"", "/", "/index", "/recipes"})
    public Set<Recipe> getRecipes(){
        log.debug("Getting Index page");
        return recipeSer.getRecipes();
    }

    @PostMapping("/newrecipe")
    public void saveRecipe(@RequestBody  Recipe recipe){
        recipeSer.addNewRecipe(recipe);
    }

    @DeleteMapping("{recipeId}")
    public void deleteRecipe(@PathVariable("recipeId") Long id){
        log.debug("deleted Recipe with id " + id);
        recipeSer.deleteRecipe(id);
    }

}
