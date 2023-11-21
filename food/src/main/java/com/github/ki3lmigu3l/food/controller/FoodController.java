package com.github.ki3lmigu3l.food.controller;

import com.github.ki3lmigu3l.food.dto.FoodRecordRequest;
import com.github.ki3lmigu3l.food.dto.FoodRecordResponse;
import com.github.ki3lmigu3l.food.model.Food;
import com.github.ki3lmigu3l.food.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {


    @Autowired
    private FoodRepository repository;

    @GetMapping
    public List<FoodRecordResponse> getAllFood() {

        List<FoodRecordResponse> foodList = repository.findAll().stream().map(FoodRecordResponse::new).toList();
        return foodList;
    }

    @PostMapping
    public void saveFood (@RequestBody FoodRecordRequest foodRequest) {
        var food = new Food(foodRequest);
        repository.save(food);
    }
}
