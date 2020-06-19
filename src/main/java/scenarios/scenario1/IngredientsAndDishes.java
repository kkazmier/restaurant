package scenarios.scenario1;

import com.example.restaurant.domain.Dish;
import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.repository.DishRepository;
import com.example.restaurant.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class IngredientsAndDishes {
    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private DishRepository dishRepository;

    private List<Ingredient> ingredients = new ArrayList<>();
    private List<Dish> dishes = new ArrayList<>();

    Ingredient in1 = new Ingredient();
    Ingredient in2 = new Ingredient();
    Ingredient in3 = new Ingredient();
    Ingredient in4 = new Ingredient();
    Ingredient in5 = new Ingredient();
    Ingredient in6 = new Ingredient();
    Ingredient in7 = new Ingredient();
    Ingredient in8 = new Ingredient();
    Ingredient in9 = new Ingredient();
    Dish dish1 = new Dish();
    Dish dish2 = new Dish();
    Dish dish3 = new Dish();
    Dish dish4 = new Dish();

    public IngredientsAndDishes(){
        createDishes();
        createIngredients();
        dependIngredientsAndDishes();
        addIngredientsAndDishesToRepository();
    }

    public void createIngredients(){
        in1.setId(1);
        in1.setName("ziemniaki");
        in1.setMeasureUnit("g");
        in1.setPrice(4.0);
        in1.setQuantity(300.0);
        in1.setType("warzywo");

        in2.setId(2);
        in2.setName("cebula");
        in2.setMeasureUnit("g");
        in2.setPrice(5.0);
        in2.setQuantity(100.0);
        in2.setType("warzywo");

        in3.setId(3);
        in3.setName("wieprzowina");
        in3.setMeasureUnit("g");
        in3.setPrice(20.0);
        in3.setQuantity(100.0);
        in3.setType("mięso");

        in4.setId(4);
        in4.setName("śmietana");
        in4.setMeasureUnit("g");
        in4.setPrice(10.0);
        in4.setQuantity(50.0);
        in4.setType("nabiał");

        in5.setId(5);
        in5.setName("ogórki");
        in5.setMeasureUnit("g");
        in5.setPrice(7.0);
        in5.setQuantity(100.0);
        in5.setType("warzywo");

        in6.setId(6);
        in6.setName("marchew");
        in6.setMeasureUnit("g");
        in6.setPrice(4.0);
        in6.setQuantity(200.0);
        in6.setType("warzywo");

        in7.setId(7);
        in7.setName("pietruszka");
        in7.setMeasureUnit("g");
        in7.setPrice(7.0);
        in7.setQuantity(100.0);
        in7.setType("warzywo");

        in8.setId(8);
        in8.setName("ser żółty");
        in8.setMeasureUnit("g");
        in8.setPrice(20.0);
        in8.setQuantity(30.0);
        in8.setType("nabiał");

        in9.setId(9);
        in9.setName("ziemniaki");
        in9.setMeasureUnit("g");
        in9.setPrice(4.0);
        in9.setQuantity(100.0);
        in9.setType("warzywo");
    }

    public void createDishes(){

        dish1.setId(1);
        dish1.setName("kotlet wieprzowy z serem");
        dish1.setPrice(8.00);

        dish2.setId(2);
        dish2.setName("mizeria z ogórków");
        dish2.setPrice(4.00);

        dish3.setId(3);
        dish3.setName("zupa jarzynowa");
        dish3.setPrice(7.00);

        dish4.setId(4);
        dish4.setName("puree ziemniaczane");
        dish4.setPrice(5.00);
    }

    public void dependIngredientsAndDishes(){
        in3.setDish(dish1);
        in8.setDish(dish1);
        dish1.getIngredients().add(in3);
        dish1.getIngredients().add(in8);
        in4.setDish(dish2);
        in5.setDish(dish2);
        dish2.getIngredients().add(in3);
        dish2.getIngredients().add(in3);
        in6.setDish(dish3);
        in7.setDish(dish3);
        in9.setDish(dish3);
    }

    public void addIngredientsAndDishesToRepository(){
        ingredients.add(in1);
        ingredients.add(in3);
        ingredients.add(in4);
        ingredients.add(in5);
        ingredients.add(in6);
        ingredients.add(in7);
        ingredients.add(in8);
        ingredients.add(in9);
        dishes.add(dish1);
        dishes.add(dish2);
        dishes.add(dish3);
        dishes.add(dish4);
        System.out.println(ingredients.size() + " " + dishes.size());
        for (Ingredient i: ingredients){
            ingredientRepository.save(i);
        }
        for (Dish d: dishes){
            dishRepository.save(d);
        }
//        ingredients.stream()
//                .forEach(i -> ingredientRepository.save(i));
//        dishes.stream()
//                .forEach(d -> dishRepository.save(d));
    }
}
