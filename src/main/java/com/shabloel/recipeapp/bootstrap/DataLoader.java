package com.shabloel.recipeapp.bootstrap;

import com.shabloel.recipeapp.model.User;
import com.shabloel.recipeapp.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author : christiaan.griffioen
 * @since :  28-6-2021, ma
 **/

@Component
public class DataLoader implements ApplicationRunner {

    private RecipeRepository recipeRepository;

    @Autowired
    public DataLoader(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User peppa = new User("Peppa", "Pig", "pig@yahoo.com");


    }


}
