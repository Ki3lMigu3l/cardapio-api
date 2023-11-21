package com.github.ki3lmigu3l.food.dto;

import com.github.ki3lmigu3l.food.model.Food;

import java.math.BigDecimal;

public record FoodRecordRequest(String nome, String imagem, BigDecimal preco) {
    public FoodRecordRequest(Food food) {
        this(food.getNome(), food.getImagem(), food.getPreco());
    }
}
