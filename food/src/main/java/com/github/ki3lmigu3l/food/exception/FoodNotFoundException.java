package com.github.ki3lmigu3l.food.exception;

public class FoodNotFoundException extends RuntimeException {
    public FoodNotFoundException(Long id) {
        super("Food with id: " + id + " not found");
    }
}
