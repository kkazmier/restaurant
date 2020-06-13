package com.example.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
