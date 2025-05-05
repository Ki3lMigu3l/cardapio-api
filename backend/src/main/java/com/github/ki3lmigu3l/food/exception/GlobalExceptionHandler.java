package com.github.ki3lmigu3l.food.exception;

import com.github.ki3lmigu3l.food.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FoodNotFoundException.class)
    public ResponseEntity<ApiError> handleFoodNotFound (FoodNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ApiError(ex.getMessage()));
    }
}
