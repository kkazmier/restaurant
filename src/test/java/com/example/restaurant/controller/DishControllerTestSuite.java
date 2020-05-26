package com.example.restaurant.controller;

import com.example.restaurant.service.DishService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(DishController.class)
public class DishControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DishService service;

    @MockBean
    private DishMapper mapper;

    @Test
    public void testGetDishes() throws Exception{
//        List<DishDto> dishes = new ArrayList<>();
//        dishes.add(new DishDto(1l, "test", 1.0, "test", new ArrayList<Ingredient>(), 1l));
//        dishes.add(new DishDto(2l, "test", 2.0, "test", new ArrayList<Ingredient>(), 2l));
//        when(service.getAllDishes()).thenReturn(dishes);
//        mockMvc.perform(get("/v1/dish/all")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk());
    }
}
