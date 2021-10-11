package com.shabloel.recipeapp.services;

import com.shabloel.recipeapp.model.User;
import com.shabloel.recipeapp.repositories.RecipeRepository;
import com.shabloel.recipeapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : christiaan.griffioen
 * @since :  28-6-2021, ma
 **/

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user){
        return userRepository.save(user);
    }
}
