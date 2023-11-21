package com.github.ki3lmigu3l.food.dto;

import com.github.ki3lmigu3l.food.model.Food;

import java.math.BigDecimal;

public record FoodRecordResponse(Long id, String nome, String image, BigDecimal preco) {
    public FoodRecordResponse(Food food){
        this(food.getId(), food.getNome(), food.getImagem(), food.getPreco());
    }
}
