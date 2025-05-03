package com.github.ki3lmigu3l.food.service;

import com.github.ki3lmigu3l.food.dto.FoodRequest;
import com.github.ki3lmigu3l.food.model.Food;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    List<Food> listAll();
    Optional<Food> searchByID(Long id);
    Food create(FoodRequest request);
    Optional<Food> update(Long id, FoodRequest request);
    void delete(Long id);
}
