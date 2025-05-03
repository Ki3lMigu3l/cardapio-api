package com.github.ki3lmigu3l.food.controller;

import com.github.ki3lmigu3l.food.dto.FoodRequest;
import com.github.ki3lmigu3l.food.dto.FoodResponse;
import com.github.ki3lmigu3l.food.model.Food;
import com.github.ki3lmigu3l.food.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FoodController {

    @Autowired
    private FoodService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Cacheable("foods")
    public List<Food> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFood(@PathVariable Long id) {
        return service.searchByID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FoodResponse registerFood(@RequestBody FoodRequest request) {
        return FoodResponse.entityToResponse(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable Long id,
                                                   @RequestBody FoodRequest request) {

        return service.update(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFood(@PathVariable Long id) {
        service.delete(id);
    }
}
