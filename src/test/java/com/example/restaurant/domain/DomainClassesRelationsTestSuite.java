package com.example.restaurant.domain;

import com.example.restaurant.repository.DishRepository;
import com.example.restaurant.repository.IngredientRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DomainClassesRelationsTestSuite {

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    DishRepository dishRepository;

    @Test
    public void testDishIngredientRelation() {
        Ingredient ingr1 = new Ingredient();
        Ingredient ingr2 = new Ingredient();
        ingr1.setName("potatoes");
        ingr2.setName("onion");
        Dish dish = new Dish();
        dish.setName("onion soup");

        ingredientRepository.save(ingr1);
        ingredientRepository.save(ingr2);
        dishRepository.save(dish);

        Assert.assertNotEquals(0, ingr1.getId());
        Assert.assertNotEquals(0, ingr2.getId());
        Assert.assertNotEquals(0, dish.getId());
    }
}
