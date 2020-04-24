package com.example.restaurant.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long ingredientId;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private Double quantity;

    @Column
    private String measureUnit;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    public static class IngredientBuilder {
        private Long ingredientId;
        private String name;
        private String type;
        private Double quantity;
        private String measureUnit;
        private String description;
        private Long dishId;

        public IngredientBuilder ingredientId(Long id){
            this.ingredientId = id;
            return this;
        }

        public IngredientBuilder name(String name){
            this.name = name;
            return this;
        }

        public IngredientBuilder type(String type){
            this.type = type;
            return this;
        }

        public IngredientBuilder quantity(double quantity){
            this.quantity = quantity;
            return this;
        }

        public IngredientBuilder measureUnit(String unit){
            this.measureUnit = unit;
            return this;
        }

        public IngredientBuilder description(String description){
            this.description = description;
            return this;
        }

        public Ingredient build(){
            return new Ingredient(
                    ingredientId,
                    name,
                    type,
                    quantity,
                    measureUnit,
                    description);
        }
    }

    private Ingredient(final Long ingredientId,
                        final String name,
                        final String type,
                        final Double quantity,
                        final String measureUnit,
                        final String description){
        this.ingredientId = ingredientId;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.measureUnit = measureUnit;
        this.description = description;
    }
}
