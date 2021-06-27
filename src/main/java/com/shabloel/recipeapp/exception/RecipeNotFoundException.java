package com.shabloel.recipeapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author : christiaan.griffioen
 * @since :  21-6-2021, ma
 **/
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecipeNotFoundException extends RuntimeException {
    public RecipeNotFoundException(String msg) {
        super(msg);
    }
}
