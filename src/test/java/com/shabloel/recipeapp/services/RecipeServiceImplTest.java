package com.shabloel.recipeapp.services;

import com.shabloel.recipeapp.exception.RecipeNotFoundException;
import com.shabloel.recipeapp.model.Recipe;
import com.shabloel.recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * @author : christiaan.griffioen
 * @since :  14-4-2021, wo
 **/
@ExtendWith(MockitoExtension.class)
public class RecipeServiceImplTest {

    @Mock
    RecipeRepository recipeRepository;

    RecipeServiceImpl recipeService;

    @Captor
    ArgumentCaptor<Recipe> recipeCaptor = ArgumentCaptor.forClass(Recipe.class);

    @BeforeEach
    public void setUp() {
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {
        //when
        recipeService.getRecipes();
        //verify
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    public void addNewRecipe() {
        //given
        Recipe recipe = new Recipe();

        //when
        recipeService.addNewRecipe(recipe);

        //then
        verify(recipeRepository).save(recipeCaptor.capture());
        Recipe capturedRecipe = recipeCaptor.getValue();
        assertThat(capturedRecipe).isEqualTo(recipe);
        //verify(recipeRepository).save(ArgumentMatchers.any(Recipe.class));
    }

    @Test
    public void DeleteRecipe() {
        //given
        Long id = 1L;
        given(recipeRepository.existsById(id))
                .willReturn(true);

        //when
        recipeService.deleteRecipe(id);

        //then
        verify(recipeRepository, times(1)).deleteById(id);
    }

    @Test
    @DisplayName("Test succesful if the recipe does not exist")
    public void DeleteRecipeWhenRecipeNotFound() {
        //given
        Long id = 1L;

        given(recipeRepository.existsById(id))
                .willReturn(false);

        //then
        verify(recipeRepository, never()).deleteById(id);

   /*     RecipeNotFoundException exception = assertThrows(RecipeNotFoundException.class, () -> {
            recipeService.deleteRecipe(id);
        });
        assertThat(exception.getMessage().contains("Recipe with id " + id + " does not exists")).isTrue();*/

        //lets use assertJ
        assertThatThrownBy(() -> {
            recipeService.deleteRecipe(id);
        }).isInstanceOf(RecipeNotFoundException.class)
                .hasMessage("Recipe with id " + id + " does not exists");
    }

}