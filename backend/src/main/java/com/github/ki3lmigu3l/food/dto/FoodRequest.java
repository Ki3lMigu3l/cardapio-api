package com.github.ki3lmigu3l.food.dto;

import com.github.ki3lmigu3l.food.model.Food;

import java.math.BigDecimal;

public record FoodRequest(String name, String image, String description, BigDecimal price) {
    public FoodRequest(Food food) {
        this(food.getName(), food.getImage(), food.getDescription(), food.getPrice());
    }
}
