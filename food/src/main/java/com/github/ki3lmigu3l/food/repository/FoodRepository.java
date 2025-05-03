package com.github.ki3lmigu3l.food.repository;

import com.github.ki3lmigu3l.food.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {}
