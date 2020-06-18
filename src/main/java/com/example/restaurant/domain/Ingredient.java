package com.example.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ingredients")
public class Ingredient extends NamedEntity {
    @Column
    private String type;

    @Column
    private Double quantity;

    @Column(name = "measure_unit")
    private String measureUnit;

    @Column
    private Double price;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            name = "dish_id",
            referencedColumnName = "id",
            nullable = false)
    private Dish dish;
}
//    public static class IngredientBuilder {
//        private Long ingredientId;
//        private String name;
//        private String type;
//        private Double quantity;
//        private String measureUnit;
//        private String description;
//
//        public IngredientBuilder ingredientId(Long id){
//            this.ingredientId = id;
//            return this;
//        }
//
//        public IngredientBuilder name(String name){
//            this.name = name;
//            return this;
//        }
//
//        public IngredientBuilder type(String type){
//            this.type = type;
//            return this;
//        }
//
//        public IngredientBuilder quantity(double quantity){
//            this.quantity = quantity;
//            return this;
//        }
//
//        public IngredientBuilder measureUnit(String unit){
//            this.measureUnit = unit;
//            return this;
//        }
//
//        public IngredientBuilder description(String description){
//            this.description = description;
//            return this;
//        }
//
//        public Ingredient build(){
//            return new Ingredient(
//                    ingredientId,
//                    name,
//                    type,
//                    quantity,
//                    measureUnit,
//                    description);
//        }
//    }
//
//    public Ingredient(final Long ingredientId,
//                        final String name,
//                        final String type,
//                        final Double quantity,
//                        final String measureUnit,
//                        final String description){
//        this.ingredientId = ingredientId;
//        this.name = name;
//        this.type = type;
//        this.quantity = quantity;
//        this.measureUnit = measureUnit;
//        this.description = description;
//    }
//}
