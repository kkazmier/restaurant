package com.example.restaurant.controller;

import com.example.restaurant.domain.dto.IngredientDto;
import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.mapper.food.IngredientMapper;
import com.example.restaurant.service.food.IngredientService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        List<IngredientDto> ingredients = new ArrayList<>();
        ingredients.add(new IngredientDto(1l, "test", "test", 1.0, "g", 1.0, "first", 1l));
        ingredients.add(new IngredientDto(2l, "test", "test", 2.0, "g", 1.0, "second", 1l));
        when(service.getAllIngredients()).thenReturn(ingredients);
        mockMvc.perform(get("/v1/ingredient/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].ingredientId", is(1)))
                .andExpect(jsonPath("$[0].quantity", is(1.0)))
                .andExpect(jsonPath("$[1].description", is("second")));
    }

    @Test
    public void testGetIngredient() throws Exception {
        when(service.getIngredientById(Mockito.eq(1l)))
                .thenReturn(Optional.of(new IngredientDto(1l, "test", "test", 1.0, "g", 1.0, "first", 1l)));
        mockMvc.perform(get("/v1/ingredient/get/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ingredientId", is(1)))
                .andExpect(jsonPath("$.name", is("test")))
                .andExpect(jsonPath("$.type", is("test")));
    }

    @Test
    public void testCreateIngredient() throws Exception{
        IngredientDto ingredient =
                new IngredientDto(1l, "test", "test", 1.0, "g", 1.0, "first", 1l);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(ingredient);
        //when(service.saveIngredient(any(IngredientDto.class))).thenReturn(new Ingredient());
        //when(mapper.mapToIngredientDto(any(Ingredient.class))).thenReturn(ingredient);
        mockMvc.perform(post("/v1/ingredient/create")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateIngredient() throws Exception {
        IngredientDto ingredient =
                new IngredientDto(1l, "test", "test", 1.0, "g", 1.0, "first", 1l);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(ingredient);
        when(service.saveIngredient(any(IngredientDto.class))).thenReturn(new Ingredient());
        when(mapper.mapToIngredientDto(any(Ingredient.class))).thenReturn(ingredient);
        mockMvc.perform(put("/v1/ingredient/update")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteIngredient() throws Exception{
        mockMvc.perform(delete("/v1/ingredient/delete/1"))
                .andExpect(status().isOk());
    }
}
