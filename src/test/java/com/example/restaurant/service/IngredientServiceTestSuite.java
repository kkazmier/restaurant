package com.example.restaurant.service;

import com.example.restaurant.repository.IngredientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class IngredientServiceTestSuite {
    @InjectMocks
    private IngredientService service;

    @Mock
    private IngredientRepository repository;

    @Test
    public void testFindIngredientById() throws Exception {
//        Optional<Ingredient> ingredient = Optional.of(new Ingredient(1l, "test", "test", 1.0, "g", 1.0, "first", 1l));
//        when(mapper.mapToIngredientDto(any(Ingredient.class)))
//                .thenReturn(ingredient.get());
//        assertThat(service.getIngredientById(Mockito.eq(1l))).isEqualTo(ingredient);
    }

    @Test
    public void testGetAllIngredients() {
//        List<IngredientDto> ingredients = new ArrayList<>();
//        ingredients.add(new IngredientDto());
//        ingredients.add(new IngredientDto());
//        when(mapper.mapToIngredientDtoList(any())).thenReturn(ingredients);
//        assertThat(service.getAllIngredients().size()).isEqualTo(2);
    }

    @Test
    public void testSaveIngredient() {
//        Ingredient ingredient = new Ingredient();
//        IngredientDto ingredientDto = new IngredientDto();
//        when(repository.save(any())).thenReturn(ingredient);
        //assertThat(service.saveIngredient(ingredientDto.)).isEqualTo(ingredient);
    }

    @Test
    public void testDeleteIngredient() {

    }
}
