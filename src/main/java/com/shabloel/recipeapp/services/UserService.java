package com.shabloel.recipeapp.services;

import com.shabloel.recipeapp.model.User;
import org.springframework.stereotype.Service;

/**
 * @author : christiaan.griffioen
 * @since :  28-6-2021, ma
 **/

@Service
public interface UserService {

    User saveUser(User user);
}
