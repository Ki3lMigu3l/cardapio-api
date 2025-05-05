package com.github.ki3lmigu3l.food.service;

import com.github.ki3lmigu3l.food.dto.FoodRequest;
import com.github.ki3lmigu3l.food.model.Food;
import com.github.ki3lmigu3l.food.repository.FoodRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository repository;

    @Override
    public List<Food> listAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Food> searchByID(Long id) {
        return repository.findById(id);
    }

    @Override
    public Food create(FoodRequest request) {
        return repository.save(new Food(request));
    }

    @Override
    public Optional<Food> update(Long id, FoodRequest foodRequest) {
        return repository
                .findById(id)
                .map(food -> {
                    food.setName(foodRequest.name());
                    food.setPrice(foodRequest.price());
                    food.setDescription(foodRequest.description());
                    food.setImage(foodRequest.image());
                    return repository.save(food);
                });
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
