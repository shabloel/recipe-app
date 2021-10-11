package com.shabloel.recipeapp.services;


import com.shabloel.recipeapp.model.Recipe;

import java.util.Set;

/**
 * @author : christiaan.griffioen
 * @since :  31-3-2021, wo
 **/

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe getRecipeById(Long id);

    void addNewRecipe(Recipe recipe);

    void deleteRecipe(Long id);
}
