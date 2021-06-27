package com.shabloel.recipeapp.controllers;


import com.shabloel.recipeapp.controller.RecipeController;
import com.shabloel.recipeapp.model.Recipe;
import com.shabloel.recipeapp.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * @author : christiaan.griffioen
 * @since :  29-4-2021, do
 **/
public class IndexControllerTest {

    @Mock
    RecipeService recipeService;
    @Mock
    Model model;
    @Captor
    ArgumentCaptor<Set<Recipe>> setRecipeCaptor = ArgumentCaptor.forClass(Set.class);

    @InjectMocks
    RecipeController recipeController;

    Set<Recipe> recipes = new HashSet<>();

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();
        recipe1.setId(1L);
        recipe2.setId(2L);
        recipes.add(recipe1);
        recipes.add(recipe2);
    }

    @Test
    public void testMockMvc() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void getRecipes() throws Exception {
        when(recipeService.getRecipes()).thenReturn(recipes);
        Set<Recipe> recipes = recipeController.getRecipes();
        //verify(model, times(1)).addAttribute(eq("recipes"), setRecipeCaptor.capture());
        assertEquals(2, recipes.size());
        verify(recipeService, times(1)).getRecipes();
        Set<Recipe> setRecipes = setRecipeCaptor.getValue();
        assertEquals(2, setRecipes.size());
        setRecipes.forEach(System.out::println);
    }
}