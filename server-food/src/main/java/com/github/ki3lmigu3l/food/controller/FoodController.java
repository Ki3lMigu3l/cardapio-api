package com.github.ki3lmigu3l.food.controller;

import com.github.ki3lmigu3l.food.dto.FoodRequest;
import com.github.ki3lmigu3l.food.dto.FoodResponse;
import com.github.ki3lmigu3l.food.model.Food;
import com.github.ki3lmigu3l.food.service.FoodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "Food Management", description = "API for managing")
public class FoodController {

    @Autowired
    private FoodService service;


    @Operation(summary = "List all foods", description = "Retrieve a list of all food items")
    @ApiResponse(responseCode = "200", description = "List of foods returned successfully",
        content = @Content(array = @ArraySchema(schema = @Schema(implementation = Food.class))))
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Cacheable("foods")
    public List<Food> listAll() {
        return service.listAll();
    }

    @Operation(summary = "Get food by ID", description = "Retrieve a single food item by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Food found",
                content = @Content(schema = @Schema(implementation = Food.class))),
            @ApiResponse(responseCode = "404", description = "Food not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Food> getFood(@PathVariable Long id) {
        return service.searchByID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new food", description = "Add a new food item to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Food created sucessfully",
                content = @Content(schema = @Schema(implementation = Food.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FoodResponse registerFood(@RequestBody FoodRequest request) {
        return FoodResponse.entityToResponse(service.create(request));
    }

    @Operation(summary = "Update an existing food", description = "Update food details by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Food updated successfully",
                    content = @Content(schema = @Schema(implementation = Food.class))),
            @ApiResponse(responseCode = "404", description = "Food not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable Long id,
                                                   @RequestBody FoodRequest request) {

        return service.update(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a food", description = "Remove a food item by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Food deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Food not found")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFood(@PathVariable Long id) {
        service.delete(id);
    }
}
