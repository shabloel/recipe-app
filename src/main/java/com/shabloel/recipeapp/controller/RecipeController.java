package com.shabloel.recipeapp.controller;

import com.shabloel.recipeapp.model.Recipe;
import com.shabloel.recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


/**
 * @author christiaan.griffioen on feb, 2021
 */
@Slf4j
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
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
}
