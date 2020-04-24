package com.example.restaurant.controller;

import com.example.restaurant.domain.Dish;
import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.mapper.IngredientMapper;
import com.example.restaurant.service.IngredientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(IngredientController.class)
public class IngredientControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IngredientService service;

    @MockBean
    private IngredientMapper mapper;

    @Test
    public void testGetIngredients() throws Exception{
        Ingredient ingredient1 = new Ingredient(1l, );
        List<Ingredient> ingredients = new ArrayList<>();
        when(service.getAllIngredients()).thenReturn(ingredients);
        mockMvc.perform(get("/v1/ingredient/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath());
    }
}
