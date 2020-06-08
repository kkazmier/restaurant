package com.example.restaurant;

import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.repository.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner checkoutIngredientEntity(IngredientRepository ingredientRepository) {
//		return (args) -> {
//			Ingredient ingr = new Ingredient();
//			ingr.setName("ziemniaki");
//			ingredientRepository.save(ingr);
//			ingr.setName("marchew");
//			ingredientRepository.save(ingr);
//			System.out.println(ingredientRepository.findAll().size());
//		};
//	}
}
