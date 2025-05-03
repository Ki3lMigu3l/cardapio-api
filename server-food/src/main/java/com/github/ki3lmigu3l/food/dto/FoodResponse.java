package com.github.ki3lmigu3l.food.dto;

import com.github.ki3lmigu3l.food.model.Food;

import java.math.BigDecimal;

public record FoodResponse(Long id, String name, String image, BigDecimal price) {
    public FoodResponse(Food food){
        this(food.getId(), food.getName(), food.getImage(), food.getPrice());
    }

    public static FoodResponse entityToResponse(Food food) {
        return new FoodResponse(
                food.getId(),
                food.getName(),
                food.getImage(),
                food.getPrice()
        );
    }
}
