package com.example.restaurant.service;

import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.domain.dto.IngredientDto;
import com.example.restaurant.mapper.IngredientMapper;
import com.example.restaurant.repository.IngredientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(IngredientService.class)
public class IngredientServiceTestSuite {
    @Autowired
    private IngredientService service;

    @Autowired
    IngredientRepository repository;

    @Autowired
    IngredientMapper mapper;

    @Test
    public void testFindIngredientById() {
        Ingredient ingredient = mapper.mapToIngredient(
                new IngredientDto(1L, "test", "test", 123.456, "?", "", 1L));
        repository.save(ingredient);
        assertThat(service.getIngredientById(1L)).isEqualTo(ingredient);
    }
}
